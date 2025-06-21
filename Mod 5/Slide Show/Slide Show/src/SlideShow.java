import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.BLUE);
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	//Updated images to the wellness locations
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/castle-hot-springs-arizona.webp\") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Golden Door – San Marcos, California.jpg\") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/\"carillon-miami-wellness-resort.webp\") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/yo1-wellness-center.jpg\") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Sensei Lanai, A Four Seasons Resort – Lanai City, Hawaii.jpg\") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	//Updated list and descriptions to wellness locations
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 Castle Hot Springs – Morristown, Arizona.</font> <br>This luxurious retreat offers everything from sound bath sessions to scenic e-bike tours. You can relish in the resort's slow pace, soak in the geothermal mineral springs, nosh on farm-to-table fare, and enjoy spa treatments and yoga classes.</body></html>";
		} else if (i==2){
			text = "<html><body><font size ='5'>#2 Golden Door – San Marcos, California<</font> <br>The exclusive experience includes a daily massage, skin treatments, and farm-to-table meals. During your downtime, you can relax in the Japanese gardens, take a dip in the pool, or hike the mountain and meadow trails.</body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>#3 Carillon Miami Wellness Resort – Miami</font><br>This five-star resort is located in Miami's North Beach neighborhood, and it has one of the largest spas on the East Coast. At Carillon Miami, guests can challenge themselves with boot camps, boxing courses, yoga classes, or hydrotherapy sessions that end in an igloo-style cooling suite. Book a cryotherapy session, float in a sensory deprivation tank, or enjoy the Atlantic Ocean views from one of the luxury apartment-style accommodations.</body></html>";
		} else if (i==4){
			text = "<html><body><font size ='5'>#4 YO1 Longevity & Health Resorts – Monticello, New York</font><br>YO1 is a wellness retreat set on 1,300 acres in New York's Catskills region, a roughly two-hour drive northwest of Manhattan, At the resort, you can work under the guidance of experts to create a personalized experience. Offerings include an Ayurvedic health center and programs that address anxiety, stress, depression, insomnia, infertility, and diabetes. The property includes 68,000 square feet of therapy areas, and it offers plenty of outdoor space for hiking, practicing yoga, and enjoying nature.</body></html>";
		} else if (i==5){
			text = "<html><body><font size = '5'>#5 Sensei Lanai, A Four Seasons Resort – Lanai City, Hawaii</font><br>Billed as a \"luxurious wellness enclave,\" Four Seasons' adults-only Sensei Lanai, in Hawaii, gives tranquility seekers optimum solitude and seclusion for all their soul-searching needs. Here, you can opt into one-on-one sessions with experts, Thai aqua therapy, lakeside yoga, and elevated spa experiences featuring infrared saunas, Japanese soaking pools, and more. The Optimal Wellbeing Program for One is a structured five-night program packed with fitness and meditation classes, personal nutrition and fitness assessments and guidance, a thermal body mapping experience, and guided hiking.</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}