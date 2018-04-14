package Model.AI;

import Model.Level.Level;

public class ConfusedAI extends AIState{

    private long startTime;
    private long duration = 7000;
    private AIController controller;
    private AIState previousState;


    public ConfusedAI(AIController controller, AIState aiState){
        startTime = System.currentTimeMillis();
        this.controller = controller;
        previousState = aiState;
    }
    @Override
    public void nextMove(Level level) {
        if(System.currentTimeMillis() > startTime + duration){
            controller.setActiveState(previousState);
        }
    }
}
