/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulation;

/**
 *
 * @author rey
 */

public class SimulationRunner {
    /**
     * Get rid of the static context.
     */
    public SimulationRunner() {
        Simulation game = new SimpleSimulation();
    }

    public static void main(String[] args) {
        SimulationRunner run = new SimulationRunner();
    }
}