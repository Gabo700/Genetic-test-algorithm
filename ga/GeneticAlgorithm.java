public class GeneticAlgorithm {
	public class GeneticAlgorithm {
	public static final int POPULATION_SIZE = 8;
	public static final int[] TARGET_CHROMOSOME = {1,1,0,1,0,0,1,1,0};
	private static final double MUTATION_RATE = 0.25;
	public static final int NUMB_OF_ELITE_CHROMOSOMES = 1;
	public static final int TOURNAMENT_SELECTION_SIZE = 4;
		
		
	public Population evolve(Population population) {
		return mutatePopulation(crossoverPopulation(population));
	}
	private Population crossoverPopulation(Population population) {
		Population crossoverPopulation = new Population(population.getChromosomes().length);
		for (int x = 0; x< NUMB_OF_ELITE_CHROMOSOMES; x++){
			crossoverPopulation.getChromosomes()[x] = population.getChromosomes()[x];
		}
		for (int x = NUMB_OF_ELITE_CHROMOSOMES; x < population.getChromosomes().length; x++) {
			Chromosome chromosome1 = selectTournamentPopulation(population).getChromosomes()[0];
			Chromosome chromosome2 = selectTournamentPopulation(population).getChromosomes()[0];
			crossoverPopulation.getChromosomes()[x] = crossoverChromosome(chromosome1, chromosome2);
		}
		
		return crossoverPopulation; 
	}
	private Population mutatePopulation(Population population) {
		Population mutatePopulation = new Population(population.getChromosomes().length);
		for (int x = 0; x < NUMB_OF_ELITE_CHROMOSOMES; x++) {
			mutatePopulation.getChromosomes()[x] = population.getChromosomes()[x];
			
		}
		for (int x = NUMB_OF_ELITE_CHROMOSOMES; x < population.getChromosomes().length; x++) {
			mutatePopulation.getChromosomes()[x] = mutateChromosome(population.getChromosomes()[x]);
		}
		return mutatePopulation;
	}
	private Chromosome crossoverChromosome(Chromosome chromosome1, Chromosome chrmosome2) {
		Chromosome crossoverChromosome = new Chromosome(TARGET_CHROMOSOME.length);
		for (int x = 0; x < chromosome1.getGenes().length; x++) {
			if (Math.random() < 0.5) crossoverChromosome.getGenes()[x] = chromosome1.getGenes()[x];
			else crossoverChromosome.getGenes()[x] = chrmosome2.getGenes()[x];
		}
		return crossoverChromosome;
	}
	private Chromosome mutateChromosome(Chromosome chromosome) {
		Chromosome mutateChromosome = new Chromosome(TARGET_CHROMOSOME.length);
		for (int x = 0; x < chromosome.getGenes().length; x++) {
			if (Math.random() < MUTATION_RATE) {
				if (Math.random() < 0.5) mutateChromosome.getGenes()[x] = 1;
				else mutateChromosome.getGenes()[x] = 0;
			} else mutateChromosome.getGenes()[x] = chromosome.getGenes()[x];
		}
		return mutateChromosome;
	}
	private Population selectTournamentPopulation(Population population) {
		Population tournamentPopulation = new Population(TOURNAMENT_SELECTION_SIZE);
		for (int x = 0; x < TOURNAMENT_SELECTION_SIZE; x++) {
			tournamentPopulation.getChromosomes()[x] = 
					population.getChromosomes()[(int)(Math.random()*population.getChromosomes().length)];
		}
		tournamentPopulation.sortChomosomesByFitness();
		return tournamentPopulation;
	}
}
