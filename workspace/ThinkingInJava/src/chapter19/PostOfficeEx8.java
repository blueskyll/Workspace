package chapter19;

import java.util.Iterator;

class Mail{
	enum GeneralDelivery{YES, NO1, NO2, NO3, NO4, NO5}
	enum Scannability{UNSCANNABLE, YES1, YES2, YES3, YES4}
	enum Readability{ILLEGIBLE, YES1, YES2, YES3, YES4}
	enum Address{INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}
	enum ReturnAddress{MISSING, OK1, OK2, OK3, OK4, OK5}
	
	GeneralDelivery generalDelivery;
	Scannability scannability;
	Readability readability;
	Address address;
	ReturnAddress returnAddress;
	
	static long counter = 0;
	long id = counter++;
	public String toString(){
		return "Mail " + id;
	}
	
	public String details(){
		return toString() + 
				"GeneralDelivery:" + generalDelivery + 
				"Scannability:" + scannability + 
				"Readability:" + readability + 
				"Address:" + address + 
				"ReturnAddress" + returnAddress;
	}
	
	public static Mail randMail(){
		Mail m = new Mail();
		m.generalDelivery = Enums.random(GeneralDelivery.class);
		m.scannability = Enums.random(Scannability.class);
		m.readability = Enums.random(Readability.class);
		m.address = Enums.random(Address.class);
		m.returnAddress = Enums.random(ReturnAddress.class);
		return m;
	}
	
	public static Iterable<Mail> generator(final int count){
		return new Iterable<Mail>(){
			int n = count;
			@Override
			public Iterator<Mail> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<Mail>(){

					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return n-- > 0;
					}

					@Override
					public Mail next() {
						// TODO Auto-generated method stub
						return Mail.randMail();
					}

					@Override
					public void remove() {
						// TODO Auto-generated method stub
						throw new UnsupportedOperationException();
					}
					
				};
			}
			
		};
	}
}


public class PostOfficeEx8 {
	enum MailHandler {
		GENERAL_DELIVERY {
			boolean handle(Mail m) {
				switch (m.generalDelivery) {
				case YES:
					System.out.println("Using general delivery for " + m);
					return true;
				default:
					return false;
				}

			}
		},

		MACHINE_SCAN {
			boolean handle(Mail m) {
				switch (m.scannability) {
				case UNSCANNABLE:
					return false;
				default:
					switch (m.address) {
					case INCORRECT:
						return false;
					default:
						System.out.println("Delivering " + m + " automatically");
						return true;
					}
				}
			}
		},

		VISUAL_INSPECTION {
			boolean handle(Mail m) {
				switch (m.readability) {
				case ILLEGIBLE:
					return false;
				default:
					switch (m.address) {
					case INCORRECT:
						return false;
					default:
						System.out.println("delivery " + m + " normally");
						return true;
					}
				}
			}
		},

		RETURN_TO_SENDER {
			boolean handle(Mail m) {
				switch (m.returnAddress) {
				case MISSING:
					return false;
				default:
					System.out.println("returning " + m + " sender");
					return true;
				}
			}
		};

		abstract boolean handle(Mail m);
	}

	static void handle(Mail m){
		for(MailHandler handler : MailHandler.values())
			if(handler.handle(m))
				return;
		System.out.println(m + " is a dead letter");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
