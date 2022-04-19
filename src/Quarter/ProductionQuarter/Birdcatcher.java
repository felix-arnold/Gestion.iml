package Quarter.ProductionQuarter;

import Quarter.Quarter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Birdcatcher extends ProductionQuarter {

    //production[food,food, birdcatcher, birdcatcher]

    public Birdcatcher(int level) {
        super(level);
        name = "Birdcatcher";
        trueName = "Birdcatcher";
        quarterIcon = new ImageView(new Image( "birdcatcherIcon.png"));
        selectedQuarterIcon = new ImageView(new Image("selectedBirdcatcherIcon.png"));
        indexConstructionPane = new int[]{0, 0, 3};
        loadAllValues();
        loadConstructionInfoPaneValue();
    }


    @Override
    public void adjacentBonuses(Quarter adjQuarter) {
        switch (adjQuarter.getTrueName()) {
            case "Birdcatcher" -> productionBonusConstant += adjQuarter.getProduction()[1]*0.3;
            case "Hellishboss" -> {
                double rnd = Math.random();
                if (rnd < adjQuarter.getProduction()[7] * adjQuarter.getLevel()) {
                    productionBonusRate += adjQuarter.getProduction()[3];
                } else if (rnd >= 100 - (adjQuarter.getProduction()[9])) {
                    productionBonusRate -= adjQuarter.getProduction()[3];
                }
            }
            case "Berth" -> productionPerCrewBonusRate += 0.05 * adjQuarter.getLevel();
        }
    }

}
