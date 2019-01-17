# first-github-assignment-oliviapy960825

# Create java files to make this code compile and run.



# What five objects are created in the main?

an array list with a generic of Dog, a dog named Fido with 4 legs, a dog named Fido with 3 legs, a dog named Alfie with 4 legs and a new comparator


# Can you spot the comparator constructor call? Where is the class definition for the comparator?
Yes, in the Collections.sort function, instead of using an input of an existing comparator, it creates a new anonymous class which implements the comparator interface directly using new Comparator<Animal>(){
  @Override
			public int compare(Animal a, Animal b){
			    return a.getLegs() - b.getLegs();
			}
}
And inside this declaration, the overridden public int compare function is the class definition
