/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peersim.gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author Dimitris
 */
public class ChordFrame extends JFrame{
    
    public ChordFrame(){
        super("Chord Viz");
        this.setLayout(new BorderLayout());
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.add(new ChordCanvas(), BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
}
