package genetic;

import java.util.Arrays;

public class Driver {
	public static void main(String[]args) {
		Population population =  new Population(GeneticAlgorithm.POPULATION_SIZE).initializePopulation();
		System.out.println("-----------------------");
		System.out.println("Generation # 0 " + " | Fittest chromosome fitness: " + population.getChromosomes()[0].getFitness());
		printPopulation(population, "Target Chromosome: "+Arrays.toString(GeneticAlgorithm.TARGET_CHROMOSOME));
	}
	public static void printPopulation(Population population, String heading) {
		System.out.println(heading);
		System.out.println("----------------------------------");
		for (int x = 0; x < population.getChromosomes().length; x++) {
			System.out.println("Chromosome # "+ x + " ; " + Arrays.toString(population.getChromosomes()[x].getGenes())+ 
					" | Fitness: "+ population.getChromosomes()[x].getFitness());
		}
	}
}
