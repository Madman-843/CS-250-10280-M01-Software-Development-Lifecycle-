import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
                topDestinationListFrame.setTitle("Top 5 Destination List");
                topDestinationListFrame.setVisible(true);
            }
        });
}  
    GridLayout destinationsGridLayout = new GridLayout(3, 1);
    JPanel parentPanel = new JPanel(destinationsGridLayout);
    	parentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    	destinationsGridLayout.setHgap(theJLabelBuffer);
    	destinationsGridLayout.setVgap(theJLabelBuffer);
    	topDestinationListFrame.getContentPane().add(parentPanel);
    GridLayout nameGridLayout = new GridLayout(7, 1);
    	destinationsGridLayout.setHgap(theJLabelBuffer);
    	destinationsGridLayout.setVgap(theJLabelBuffer);
    JPanel namePanel = new JPanel(nameGridLayout);
    	namePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    	namePanel.setBackground(new HexColor(0, 0, 255));
    	JLabel Name = new JLabel(" Jacob Griggs "); //Name Label  
    	JLabel Professor = new JLabel("Professor Trevor Hodde");
    	JLabel Course = new JLabel("CS-250 Software Development Lifecycle" );
    	JLabel Date = new JLabel("5/23/2025") ;
private DefaultListModel listModel;

    public TopDestinationListFrame() {
        super("Top Five Destination List");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 750);

        listModel = new DefaultListModel();


        //Make updates to your top 5 list below. Import the new image files to resources directory.
        addDestinationNameAndPicture("1. - Swiss Alps, Switzerland – A breathtaking mix of snow-covered mountains, charming villages, and world-class skiing.\r\n"
        		+ "- \r\n", new ImageIcon(getClass().getResource("/resources/Swiss_Alps.jpg")));
        addDestinationNameAndPicture("2. - Bora Bora, French Polynesia – A tropical paradise with stunning beaches, lush jungles, and luxurious resorts.\r\n"
        		+ "- \r\n", new ImageIcon(getClass().getResource("/resources/Bora_Bora.jpg")));
        addDestinationNameAndPicture("3. - Rome, Italy – A historic city packed with iconic landmarks like the Colosseum, Trevi Fountain, and Pantheon.\r\n"
        		+ "- \r\n", new ImageIcon(getClass().getResource("/resouJLrces/Rome.jpg")));
        addDestinationNameAndPicture("4. - Tokyo, Japan – A vibrant metropolis blending ancient traditions with cutting-edge technology and incredible cuisine.\r\n"
        		+ "- \r\n", new ImageIcon(getClass().getResource("/resources/Tokyo.jpg")));
        addDestinationNameAndPicture("5. - Maui, Hawaii, USA – A dream destination with volcanic landscapes, pristine beaches, and lush rainforests.\r\n"
        		+ "\r\n", new ImageIcon(getClass().getResource("/resources/Maui.jpg")));
        
        JList list = new JList(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);

        list.setCellRenderer(renderer);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addDestinationNameAndPicture(String text, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, icon);
        listModel.addElement(tai);
    }
}


class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}


class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer {
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel.
        setText(tai.getText());
        setIcon(tai.getIcon());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}