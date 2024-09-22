import java.io.IOException;

import javax.swing.SwingUtilities;

public class KnowledgeGraphTest {
	public static void main(String[] args) {
        try {
            KnowledgeGraph knowledgeGraph = new KnowledgeGraph("Sample-dataset-project.20240305.xlsx");
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new GraphFrame(knowledgeGraph);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
