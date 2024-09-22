/**exercise 3
*@author: Tran
**/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphFrame extends JFrame {

    private JTextField entityOneField;
    private JTextField relationNameField;
    private JTextField entityTwoField;
    private KnowledgeGraph knowledgeGraph;

    public GraphFrame(KnowledgeGraph knowledgeGraph) {
        super("Knowledge Graph");
        this.knowledgeGraph = knowledgeGraph; // Assign the provided KnowledgeGraph object

        // Create text fields for user input
        entityOneField = new JTextField(20);
        relationNameField = new JTextField(20);

        // Create a button for triggering processing
        JButton processButton = new JButton("Print All Data");
        processButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                knowledgeGraph.printAllData();
            }
        });

        // Create a button to search association with entity
        JButton searchAssociationsButton = new JButton("Search Associations");
        searchAssociationsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get user input
                String entityOne = entityOneField.getText();

                // Process the input
                if (knowledgeGraph != null) {
                    knowledgeGraph.searchAssociateWithEntity(entityOne);
                } else {
                    System.out.println("KnowledgeGraph is not initialized.");
                }
            }
        });

        // Create a button to search relation pairs
        JButton searchPairsButton = new JButton("Search Relation Pairs");
        searchPairsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get user input
                String relationName = relationNameField.getText();

                // Process the input
                if (knowledgeGraph != null) {
                    knowledgeGraph.searchRelationPairsWith(relationName);
                } else {
                    System.out.println("KnowledgeGraph is not initialized.");
                }
            }
        });

        // Create a button to search entity two
        JButton searchEntityTwoButton = new JButton("Search Entity Two");
        searchEntityTwoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get user input
                String entityOne = entityOneField.getText();
                String relationName = relationNameField.getText();

                // Process the input
                if (knowledgeGraph != null) {
                    knowledgeGraph.searchEntityTwo(entityOne, relationName);
                } else {
                    System.out.println("KnowledgeGraph is not initialized.");
                }
            }
        });

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.add(new JLabel("Entity One:"));
        panel.add(entityOneField);
        panel.add(new JLabel("Relation Name:"));
        panel.add(relationNameField); 
        panel.add(processButton);
        panel.add(searchAssociationsButton);
        panel.add(searchPairsButton);
        panel.add(searchEntityTwoButton);

        // Add the panel to the frame
        getContentPane().add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}