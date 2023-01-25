package net.paperdave.csi2130.runner;

import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class LabRunnerFrame extends JFrame {
    private static final int PADDING = 10;
    private static final int LIST_WIDTH = 300;
    private static final int BUTTON_HEIGHT = 60;

    private Example[] examples;

    public LabRunnerFrame(Example[] examples) {
        super("Dave's CSI 2130 Lab Runner");

        this.examples = examples;

        // This will be a two column layout using SpringLayout, where the left is a list view,
        // and the right side is the item details, which will be split into two rows, one for
        // the description, and one for the output, and then a button below everything to run/rerun the lab.

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);

        // set the window style to look like windows 10


        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);

        JList<LabItem> labList = new JList<>(Arrays.stream(examples).map(LabItem::new).toArray(LabItem[]::new));
        labList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        labList.setLayoutOrientation(JList.VERTICAL);
        labList.setVisibleRowCount(-1);
        this.add(labList);
        layout.putConstraint(SpringLayout.WEST, labList, PADDING, SpringLayout.WEST, this.getContentPane());
        layout.putConstraint(SpringLayout.NORTH, labList, PADDING, SpringLayout.NORTH, this.getContentPane());
        layout.putConstraint(SpringLayout.EAST, labList, PADDING + LIST_WIDTH, SpringLayout.WEST, this.getContentPane());
        layout.putConstraint(SpringLayout.SOUTH, labList, -PADDING, SpringLayout.SOUTH, this.getContentPane());

        JButton runButton = new JButton("Run Lab");
        this.add(runButton);
        layout.putConstraint(SpringLayout.WEST, runButton, PADDING, SpringLayout.EAST, labList);
        layout.putConstraint(SpringLayout.SOUTH, runButton, -PADDING, SpringLayout.SOUTH, this.getContentPane());
        layout.putConstraint(SpringLayout.EAST, runButton, -PADDING, SpringLayout.EAST, this.getContentPane());
        runButton.setPreferredSize(new Dimension(0, BUTTON_HEIGHT));

        JTextArea labDescription = new JTextArea();
        labDescription.setEditable(false);
        labDescription.setLineWrap(true);
        labDescription.setWrapStyleWord(true);
        labDescription.setText("Select a lab from the left.");
        this.add(labDescription);
        JTextArea labOutput = new JTextArea();
        labOutput.setEditable(false);
        labOutput.setLineWrap(true);
        labOutput.setWrapStyleWord(true);
        labOutput.setText("[lab output here]");
        labOutput.setFont(new Font("Monospaced", Font.PLAIN, 14));
        this.add(labOutput);

        GridLayout labDetailsLayout = new GridLayout(2, 1);
        labDetailsLayout.setVgap(PADDING);
        JPanel labDetails = new JPanel(labDetailsLayout);
        labDetails.add(labDescription);
        labDetails.add(labOutput);
        this.add(labDetails);
        layout.putConstraint(SpringLayout.WEST, labDetails, PADDING, SpringLayout.EAST, labList);
        layout.putConstraint(SpringLayout.NORTH, labDetails, PADDING, SpringLayout.NORTH, this.getContentPane());
        layout.putConstraint(SpringLayout.EAST, labDetails, -PADDING, SpringLayout.EAST, this.getContentPane());
        layout.putConstraint(SpringLayout.SOUTH, labDetails, PADDING, SpringLayout.NORTH, runButton);

        labList.addListSelectionListener(e -> {
            LabItem item = labList.getSelectedValue();
            if (item != null) {
                labDescription.setText(item.example().getDescription());
            } else {
                labDescription.setText("Select a lab from the left.");
            }
            labOutput.setText("");
        });

        runButton.addActionListener(e -> {
            LabItem item = labList.getSelectedValue();
            if (item != null) {
                PrintStream stdout = System.out;
                System.setOut(new PrintStream(new OutputStream() {
                    @Override
                    public void write(int b) {
                        labOutput.append(String.valueOf((char) b));
                    }
                    public String toString(){
                        return labOutput.getText();
                    }
                }));
                item.example().run();
                System.setOut(stdout);
            } else {
                labOutput.setText("no lab selected");
            }
        });

    }
}
