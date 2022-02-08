package Quarter.ProductionQuarter;

import Quarter.Quarter;

public class TemporalCamboose extends ProductionQuarter{

    public TemporalCamboose() {

        super();
        name = "TemporalCamboose";
        productionType=9; //9=food
    }

    @Override
    public void adjacentBonuses(Quarter adjQuarter) {
        switch (adjQuarter.getName()) {
            case "Cryptominer" -> productionPerCrewBonusRate -= 0.01 * adjQuarter.getCrew();
            case "Restroom" -> productionPerCrewBonusRate += 0.05 * adjQuarter.getLevel();
            case "Cryptoinvestor" -> {
                double rnd = Math.random();
                if (rnd < adjQuarter.getProduction()[3] * adjQuarter.getLevel()) {
                    productionBonusConstant += adjQuarter.getProduction()[1];
                } else if (rnd >= 100-(adjQuarter.getProduction()[5])) {
                    productionBonusConstant -= adjQuarter.getProduction()[1];
                }
            }
            case "ParadoxalGenerator" -> productionBonusRate += 0.05*adjQuarter.getLevel();
            case "DimensionlessSpace" -> productionBonusRate += adjQuarter.getProduction()[1];
        }
    }
}
