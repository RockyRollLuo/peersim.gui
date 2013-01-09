package peersim.gui;

import edu.umd.cs.piccolo.PNode;
import java.awt.Color;
import java.awt.GridLayout;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Dimitris
 */
public class InfoPanel extends JPanel {

    private JLabel NodeLabel = new JLabel("Currently selected Node ID:");
    private JLabel PredLabel = new JLabel("Current Predecessor Node ID:");
    private JLabel SuccLabel = new JLabel("Current Successor Node ID:");
    private JLabel NodeId = new JLabel("none");
    private JLabel PredId = new JLabel("none");
    private JLabel SuccId = new JLabel("none");
    private JLabel FingLabel = new JLabel("Finger node IDs:");
    private JLabel NoneLabel = new JLabel("none");
    private JLabel stepLabel = new JLabel("Steps:");
    private JLabel gotoLabel = new JLabel("Go to event:");
    private JButton backButton = new JButton("Back 1 event");
    private JButton fwdButton = new JButton("Move 1 event");
    private JButton gotoButton = new JButton(">>");
    private JTextField stepTextField = new JTextField();
    private JTextField gotoTextField = new JTextField();
    private JPanel FingPanel = new JPanel(new GridLayout(0,1));

    public InfoPanel() {
        super();
        setLayout(new MigLayout("wrap 1"));
        stepTextField.setText("1");
        gotoTextField.setText("0");
        
        add(stepLabel, "split 2");
        add(stepTextField, "grow");
        add(backButton, "split 2");
        add(fwdButton);
        add(gotoLabel, "split 3");
        add(gotoTextField, "grow");
        add(gotoButton, "shrink");
        add(NodeLabel);
        add(NodeId);
        add(PredLabel);
        add(PredId);
        add(SuccLabel);
        add(SuccId);
        add(FingLabel);
        add(NoneLabel);
        add(FingPanel, "gapleft");        
        setVisible(true);
    }

    public void setNodeId(String newID) {
        NodeId.setText(newID);
    }

    public void resetNodeId() {
        NodeId.setText("none");
    }

    public void setPredId(String newID) {
        PredId.setText(newID);
    }

    public void resetPredId() {
        PredId.setText("none");
    }

    public void setSuccId(String newID) {
        SuccId.setText(newID);
    }

    public void resetSuccId() {
        SuccId.setText("none");
    }
    
    public void addFingersToPanel(ArrayList<PNode> arrayList) {
        remove(NoneLabel);
        FingPanel.removeAll();
        for (int i = 0; i < arrayList.size(); i++) {
            if ((PNode) arrayList.get(i) != null) {
                FingPanel.add(new JLabel("Finger " + Integer.toString(i) + " node ID:"), "align left");
                FingPanel.add(new JLabel(((BigInteger) ((PNode) arrayList.get(i)).getAttribute("chordId")).toString(16)), "align left");
            }
        }
    }

    public void resetFingers() {
        FingPanel.removeAll();
        add(NoneLabel);
    }

    public void resetInfo() {
        resetNodeId();
        resetPredId();
        resetSuccId();
        resetFingers();
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getFwdButton() {
        return fwdButton;
    }

    public JTextField getTxtField() {
        return stepTextField;
    }
}
