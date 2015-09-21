/*
 * Copyright (c) 1998, 2012, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

#ifndef _JAVA_H_
#define _JAVA_H_

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

#include <jni.h>
#include <jvm.h>

/*
 * Get system specific defines.
 */
#include "emessages.h"
#include "java_md.h"
#include "jli_util.h"

#include "manifest_info.h"
#include "version_comp.h"
#include "wildcard.h"
#include "splashscreen.h"

# define KB (1024UL)
# define MB (1024UL * KB)
# define GB (1024UL * MB)

#define CURRENT_DATA_MODEL (CHAR_BIT * sizeof(void*))

/*
 * The following environment variable is used to influence the behavior
 * of the jre exec'd through the SelectVersion routine.  The command line
 * options which specify the version are not passed to the exec'd version,
 * because that jre may be an older version which wouldn't recognize them.
 * This environment variable is known to this (and later) version and serves
 * to suppress the version selection code.  This is not only for efficiency,
 * but also for correctness, since any command line options have been
 * removed which would cause any value found in the manifest to be used.
 * This would be incorrect because the command line options are defined
 * to take precedence.
 *
 * The value associated with this environment variable is the MainClass
 * name from within the executable jar file (if any). This is strictly a
 * performance enhancement to avoid re-reading the jar file manifest.
 *
 */
#define ENV_ENTRY "_JAVA_VERSION_SET"

#define SPLASH_FILE_ENV_ENTRY "_JAVA_SPLASH_FILE"
#define SPLASH_JAR_ENV_ENTRY "_JAVA_SPLASH_JAR"

/*
 * Pointers to the needed JNI invocation API, initialized by LoadJavaVM.
 */
typedef jint (JNICALL *CreateJavaVM_t)(JavaVM **pvm, void **env, void *args);
typedef jint (JNICALL *GetDefaultJavaVMInitArgs_t)(void *args);
typedef jint (JNICALL *GetCreatedJavaVMs_t)(JavaVM **vmBuf, jsize bufLen, jsize *nVMs);

typedef struct {
    CreateJavaVM_t CreateJavaVM;
    GetDefaultJavaVMInitArgs_t GetDefaultJavaVMInitArgs;
    GetCreatedJavaVMs_t GetCreatedJavaVMs;
} InvocationFunctions;

int
JLI_Launch(int argc, char ** argv,              /* main argc, argc */
        int jargc, const char** jargv,          /* java args */
        int appclassc, const char** appclassv,  /* app classpath */
        const char* fullversion,                /* full version defined */
        const char* dotversion,                 /* dot version defined */
        const char* pname,                      /* program name */
        const char* lname,                      /* launcher name */
        jboolean javaargs,                      /* JAVA_ARGS */
        jboolean cpwildcard,                    /* classpath wildcard */
        jboolean javaw,                         /* windows-only javaw */
        jint     ergo_class                     /* ergnomics policy */
);

/*
 * Prototypes for launcher functions in the system specific java_md.c.
 */

jboolean
LoadJavaVM(const char *jvmpath, InvocationFunctions *ifn);

void
GetXUsagePath(char *buf, jint bufsize);

jboolean
GetApplicationHome(char *buf, jint bufsize);

#define GetArch() GetArchPath(CURRENT_DATA_MODEL)

/*
 * Different platforms will implement this, here
 * pargc is a pointer to the original argc,
 * pargv is a pointer to the original argv,
 * jrepath is an accessible path to the jre as determined by the call
 * so_jrepath is the length of the buffer jrepath
 * jvmpath is an accessible path to the jvm as determined by the call
 * so_jvmpath is the length of the buffer jvmpath
 */
void CreateExecutionEnvironment(int *argc, char ***argv,
                                char *jrepath, jint so_jrepath,
                                char *jvmpath, jint so_jvmpath,
                                char *jvmcfg,  jint so_jvmcfg);

/* Reports an error message to stderr or a window as appropriate. */
void JLI_ReportErrorMessage(const char * message, ...);

/* Reports a system error message to stderr or a window */
void JLI_ReportErrorMessageSys(const char * message, ...);

/* Reports an error message only to stderr. */
void JLI_ReportMessage(const char * message, ...);

/*
 * Reports an exception which terminates the vm to stderr or a window
 * as appropriate.
 */
void JLI_ReportExceptionDescription(JNIEnv * env);
void PrintMachineDependentOptions();

const char *jlong_format_specifier();

/*
 * Block current thread and continue execution in new thread
 */
int ContinueInNewThread0(int (JNICALL *continuation)(void *),
                        jlong stack_size, void * args);

/* sun.java.launcher.* platform properties. */
void SetJavaLauncherPlatformProps(void);
void SetJavaCommandLineProp(char* what, int argc, char** argv);
void SetJavaLauncherProp(void);

/*
 * Functions defined in java.c and used in java_md.c.
 */
jint ReadKnownVMs(const char *jvmcfg, jboolean speculative);
char *CheckJvmType(int *argc, char ***argv, jboolean speculative);
void AddOption(char *str, void *info);

enum ergo_policy {
   DEFAULT_POLICY = 0,
   NEVER_SERVER_CLASS,
   ALWAYS_SERVER_CLASS
};

const char* GetProgramName();
const char* GetDotVersion();
const char* GetFullVersion();
jboolean IsJavaArgs();
jboolean IsJavaw();
jint GetErgoPolicy();

jboolean ServerClassMachine();

int ContinueInNewThread(InvocationFunctions* ifn, jlong threadStackSize,
                   int argc, char** argv,
                   int mode, char *what, int ret);

int JVMInit(InvocationFunctions* ifn, jlong threadStackSize,
                   int argc, char** argv,
                   int mode, char *what, int ret);

/*
 * Initialize platform specific settings
 */
void InitLauncher(jboolean javaw);

/*
 * For MacOSX and Windows/Unix compatibility we require these
 * entry points, some of them may be stubbed out on Windows/Unixes.
 */
void     PostJVMInit(JNIEnv *env, jstring mainClass, JavaVM *vm);
void     ShowSplashScreen();
void     RegisterThread();
/*
 * this method performs additional platform specific processing and
 * should return JNI_TRUE to indicate the argument has been consumed,
 * otherwise returns JNI_FALSE to allow the calling logic to further
 * process the option.
 */
jboolean ProcessPlatformOption(const char *arg);

/*
 * This allows for finding classes from the VM's bootstrap class loader directly,
 * FindClass uses the application class loader internally, this will cause
 * unnecessary searching of the classpath for the required classes.
 *
 */
typedef jclass (JNICALL FindClassFromBootLoader_t(JNIEnv *env,
                                                  const char *name));
jclass FindBootStrapClass(JNIEnv *env, const char *classname);

jobjectArray CreateApplicationArgs(JNIEnv *env, char **strv, int argc);
jobjectArray NewPlatformStringArray(JNIEnv *env, char **strv, int strc);
jclass GetLauncherHelperClass(JNIEnv *env);

int JNICALL JavaMain(void * args); /* entry point                  */

enum LaunchMode {               // cf. sun.launcher.LauncherHelper
    LM_UNKNOWN = 0,
    LM_CLASS,
    LM_JAR
};

static const char *launchModeNames[]
    = { "Unknown", "Main class", "JAR file" };

typedef struct {
    int    argc;
    char **argv;
    int    mode;
    char  *what;
    InvocationFunctions ifn;
} JavaMainArgs;

#define NULL_CHECK0(e) if ((e) == 0) { \
    JLI_ReportErrorMessage(JNI_ERROR); \
    return 0; \
  }

#define NULL_CHECK(e) if ((e) == 0) { \
    JLI_ReportErrorMessage(JNI_ERROR); \
    return; \
  }

#endif /* _JAVA_H_ */
