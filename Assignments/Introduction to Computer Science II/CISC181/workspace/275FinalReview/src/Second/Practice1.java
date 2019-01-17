package Second;

interface Predicate<T>{
	boolean test(T t);
}

class Dog
{
	private int age;
	int getAge(){return age;}
	Dog(int age){this.age = age;}
}

class Practice1{
	static void print(Dog c, Predicate<Dog> ch){
		System.out.println(ch.test(c) ? "YES" : "NO");
	}
	public static void main(String[] spam){
		Dog c1 = new Dog(5);
		print(c1, new Predicate<Dog>(){
			public boolean test(Dog d){
				return d.getAge() < 5;
			}
		});
		//better?
	}
}
	
	

