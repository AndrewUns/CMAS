/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andrew Unsworth
 */
public class CMAS2 {
    // declare the confusion matrix variables 
	private double truePositives = 0;
	private double falseNegatives = 0;
	private double falsePositives = 0;
	private double trueNegatives = 0;
	private double totalSample = 0;
	
	// declare the classification accuracy stats
	private double sensitivity = 0;
	private double specificity = 0;
	private double precision = 0;
	private double recall = 0;
	private double fMeasure = 0;
	private double overallAccuracy = 0;
	private double overallError = 0;
	private double cohensKappa = 0;
	private double randomGuess = 0;
        private double[] allCalcsArray = new double[8];
	
	
	public CMAS2 (int tP, int fN, int fP, int tN) {
		
		// assign values to confusion matrix variables
		truePositives = (double) tP;
		falseNegatives = (double)fN;
		falsePositives = (double)fP;
		trueNegatives = (double)tN;
		totalSample = (double)(truePositives + falseNegatives + falsePositives + trueNegatives);
		printConfusionMatrix();
                
                /* call the various accuracy stat functions and instantiate 
                   the class variuables */
                System.out.println("Calling all the stat calc functions");
                sensitivity = sensitivityCalc();
                specificity = specificityCalc();
                precision = precisionCalc();
                recall = recallCalc();
                fMeasure = fMeasureCalc();
                overallAccuracy = overallAccuracyCalc();
                overallError = overallErrorCalc();
                cohensKappa = cohensKappaCalc();
                
                createStatArray(); 
                }
	
	private void printConfusionMatrix() {
		// print values of the confusion matrix variables
		System.out.println("number of true positives: " + truePositives);
		System.out.println("Number of false negatives: " + falseNegatives);
		System.out.println("Number of false positives: " + falsePositives);
		System.out.println("Number of true Negatives: " + trueNegatives);
		System.out.println("Total number of class events:" + (truePositives + falseNegatives + falsePositives + trueNegatives));
	}
	
	private double sensitivityCalc() {
		// calculate sensitivity
		sensitivity = (double) truePositives/(truePositives + falseNegatives);
		
		// output result to standard output for checking
		System.out.println("Sensitivity == " + sensitivity);
		
		// return the result
		return sensitivity;
		
	}
	
	private double specificityCalc() {
		// calculate specificity
		specificity = (double) trueNegatives/(trueNegatives + falsePositives);
		System.out.println("Specificity == " + specificity);
		
		return specificity;
	}
	
	private double precisionCalc() {
		// calulate precision
		precision = (double) truePositives/(truePositives + falsePositives);
		System.out.println("Precision == " + precision);
		
		return precision;
		
	}
	
	private double recallCalc() {
		// calculate recall
		recall = (double) truePositives/(truePositives + falseNegatives);
		System.out.println("Recall == " + recall);
		
		return recall;
	}
	
	private double fMeasureCalc() {
		// calculate F-measure
		fMeasure = 2 * ((precision * recall) / (precision + recall));
		System.out.println("F-mreasure == " + fMeasure);
		
		return fMeasure;
	}
	
	private double overallAccuracyCalc() {
		// calculate the overall accuracy of the classification
		overallAccuracy = (double) (truePositives + trueNegatives)/(truePositives + falsePositives + falseNegatives + trueNegatives);
		System.out.println("Overall accuracy == " + overallAccuracy);
		
		return overallAccuracy;
	}
	
	private double overallErrorCalc() {
		/* calculate the overall error of the classification. Overall error is calculated from scratch 
		   instead of 1-overall accuracy because we can't assume overall accuracy has been calculated 
		   prior to this method call */
		overallError = (double) (falseNegatives + falsePositives) / (truePositives + falsePositives + falseNegatives + trueNegatives);
		System.out.println("Overall error == " + overallError);
				
		return overallError;
	}
	
	private double cohensKappaCalc() {
		// calculate Cohen's Kappa
		randomGuess = (((truePositives + falseNegatives)/totalSample) * ((truePositives + falsePositives)/totalSample)) + (((falsePositives + trueNegatives)/totalSample) * ((falseNegatives + trueNegatives)/totalSample));
		System.out.println("Random Guess == " + randomGuess);
		cohensKappa = (double) (overallAccuracy - randomGuess) / (1-randomGuess);
		System.out.println("Cohen's Kappa == " + cohensKappa);
		
		return cohensKappa;
	}
	
        private void createStatArray() {
            allCalcsArray = new double[]{sensitivity, specificity, precision, recall, fMeasure, overallAccuracy, overallError, cohensKappa};
        }

	// provide getter methods for obtaining accuracy stats and the full array of stats    
        public double getSensitivity() {
            return sensitivity;
        }
        
        public double getSpecificity() {
            return specificity;
        }
        
        public double getPrecision() {
            return precision;
        }
        
        public double getRecall() {
            return recall;
        }
        
        public double getfMeasure() {
            return fMeasure;
        }
        
        public double getOverallAccuracy() {
            return overallAccuracy;
        }
        
        public double getOverallError() {
            return overallError;
        }
        
        public double getCohensKappa() {
            return cohensKappa;
        }
        
        // create a function that packages all the calcs in an array
        public double[] getAllCalcsArray() {
                        
            return allCalcsArray;
        }
        
}
