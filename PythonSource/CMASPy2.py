class CMAS2:
    """A class that takes binomial confusion matrix data as input and calculates classification accuracy statistics.
       CMAS is short for Confusion Matrix Accuracy Statistics.
       Written by Andrew Unsworth"""
    
    # declare confusion matrix variables
    truePositives = 0
    falseNegatives = 0
    falseNegatives = 0
    falsePositives = 0
    trueNegatives = 0
    totalSample = 0
    
    # declare the classification accuracy stats
    sensitivity = 0
    specificity = 0
    precision = 0
    recall = 0
    fMeasure = 0
    overallAccuracy = 0
    overallError = 0
    cohensKappa = 0
    randomGuess = 0

    # call constructor to assign values to confusion matrix variables
    def __init__(self, tP, fN, fP, tN):

        # instantiate confusion matrix class variables
        self.truePositives = tP
        self.falseNegatives = fN
        self.falsePositives = fP
        self.trueNegatives = tN

        # sum total sample and assign it to the class variable
        self.totalSample = (self.truePositives + self.falseNegatives + self.falsePositives + self.trueNegatives)

        # calculate the various accuracy stats and instatiate the class variables
        self.sensitivity = self.sensitivityCalc()
        self.specificity = self.specificityCalc()
        self.precision = self.precisionCalc()
        self.recall = self.recallCalc()
        self.fMeasure = self.fMeasureCalc()
        self.overallAccuracy = self.overallAccuracyCalc()
        self.overallError = self.overallErrorCalc()
        self.cohensKappa = self.cohensKappaCalc()
        
    
    # calculate sensitivity
    def sensitivityCalc(self):
        self.sensitivity = self.truePositives/(self.truePositives + self.falseNegatives)
        return self.sensitivity

    # calculate specificity
    def specificityCalc(self):
        self.specificity = self.trueNegatives/(self.trueNegatives + self.falsePositives)

        return self.specificity
        
    # calculate precision
    def precisionCalc(self):
        self.precision = self.truePositives/(self.truePositives + self.falsePositives)

        return self.precision

    # calculate recall
    def recallCalc(self):
        self.recall = self.truePositives/(self.truePositives + self.falseNegatives)

        return self.recall

    # calculate F-measure
    def fMeasureCalc(self):
        self.fMeasure = 2 * ((self.precision * self.recall) / (self.precision + self.recall))

        return self.fMeasure

    # calculate overall accuracy
    def overallAccuracyCalc(self):
        self.overallAccuracy = (self.truePositives + self.trueNegatives)/(self.truePositives + self.falsePositives + self.falseNegatives + self.trueNegatives)

        return self.overallAccuracy

    # calculate overall error (calculated from scratch instead of 1-overallAccuracy because we can't assume overallAccuracy has been calculated prior to this method call
    def overallErrorCalc(self):
        self.overallError = (self.falseNegatives + self.falsePositives) / (self.truePositives + self.falseNegatives + self.falsePositives + self.trueNegatives)

        return self.overallError

    # calculate Cohen's kappa
    def cohensKappaCalc(self):
        self.randomGuess = (((self.truePositives + self.falseNegatives)/self.totalSample) * ((self.truePositives + self.falsePositives)/self.totalSample)) + (((self.falsePositives + self.trueNegatives)/self.totalSample) * ((self.falseNegatives + self.trueNegatives)/self.totalSample))
        self.cohensKappa = (self.overallAccuracy - self.randomGuess)/(1-self.randomGuess)
        
        return self.cohensKappa
        
    
    
