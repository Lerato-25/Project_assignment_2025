import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TutorsProfile extends JFrame {

    public TutorsProfile() {
        setTitle("Tutor Profiles");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(20, 10, 10, 10));
        contentPanel.setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(250, 250, 250)); 

        JPanel gridPanel = new JPanel(new GridLayout(2, 3, 20, 20)); 
        gridPanel.setBackground(new Color(250, 250, 250));

        String[] names = {"Lerato Letsoele", "Inarm Klass", "Leeroy Chakanyuka", "Tonny Baloyi", "Abulele", "Lindiwe Azefo"};
        String[] subjects = {"Mathematics, Physical Science", "Life Sciences, Biology", "English, History", "Physical Science, Chemistry", "Mathematics, Accounting", "Geography, Life Orientation"};
        String[] qualifications = {"BSc Education", "BSc Biological Sciences", "BA Education", "BSc Physical Sciences", "BCom Accounting", "BA Geography"};
        String[] experiences = {"5 Years", "3 Years", "6 Years", "4 Years", "2 Years", "3 Years"};
        String[] ratings = {"4.7", "4.5", "4.9", "4.6", "4.4", "4.5"};

        
        for (int i = 0; i < names.length; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBackground(Color.WHITE);
            panel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));  

            JLabel profilePic = new JLabel(new ImageIcon(
            new ImageIcon(getClass().getResource("/img/profile_icon.jpg")).getImage()
              .getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            profilePic.setAlignmentX(Component.CENTER_ALIGNMENT);
           // profilePic.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            profilePic.setOpaque(true);
            profilePic.setBackground(Color.LIGHT_GRAY);

            JLabel name = new JLabel(names[i], JLabel.CENTER);
            name.setFont(new Font("Arial", Font.BOLD, 22));
            name.setAlignmentX(Component.CENTER_ALIGNMENT);
            name.setForeground(new Color(45, 45, 45));

            JLabel sub = new JLabel("Subjects: " + subjects[i]);
            sub.setFont(new Font("Arial", Font.PLAIN, 16));
            sub.setAlignmentX(Component.CENTER_ALIGNMENT);
            sub.setForeground(new Color(80, 80, 80));

            JLabel qual = new JLabel("Qualification: " + qualifications[i]);
            qual.setFont(new Font("Arial", Font.PLAIN, 16));
            qual.setAlignmentX(Component.CENTER_ALIGNMENT);
            qual.setForeground(new Color(80, 80, 80));

            JLabel exp = new JLabel("Experience: " + experiences[i]);
            exp.setFont(new Font("Arial", Font.PLAIN, 16));
            exp.setAlignmentX(Component.CENTER_ALIGNMENT);
            exp.setForeground(new Color(80, 80, 80));

            StringBuilder ratingStars = new StringBuilder();
            double ratingValue = Double.parseDouble(ratings[i]);
            int fullStars = (int) ratingValue;
            boolean hasHalfStar = (ratingValue - fullStars) >= 0.5;

            for (int j = 0; j < fullStars; j++) {
                ratingStars.append("★");
            }

            if (hasHalfStar) {
                ratingStars.append("⯨"); 
            }

         
            int remainingStars = 5 - fullStars - (hasHalfStar ? 1 : 0);
            for (int j = 0; j < remainingStars; j++) {
                ratingStars.append("☆");
            }

            JLabel rate = new JLabel("Rating: " + ratingStars.toString() + " (" + ratings[i] + "/5)");
            rate.setFont(new Font("Arial", Font.PLAIN, 16));
            rate.setForeground(new Color(255, 140, 0)); // Orange color for rating
            rate.setAlignmentX(Component.CENTER_ALIGNMENT);

            final int index = i;
            JButton bookButton = new JButton("Book Session");
            bookButton.setFont(new Font("Arial", Font.BOLD, 16));
            bookButton.setBackground(new Color(173, 216, 230)); // Light blue
            bookButton.setForeground(Color.WHITE);
            bookButton.setFocusPainted(false);
            bookButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            bookButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            bookButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    bookButton.setBackground(new Color(135, 206, 235));
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    bookButton.setBackground(new Color(173, 216, 230)); 
                }
            });

            bookButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Session booked with " + names[index]));

            JButton prepButton = new JButton("Exam Prep Tips");
            prepButton.setFont(new Font("Arial", Font.BOLD, 16));
            prepButton.setBackground(new Color(230, 230, 250)); 
            prepButton.setForeground(Color.BLACK);
            prepButton.setFocusPainted(false);
            prepButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            prepButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            prepButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    prepButton.setBackground(new Color(221, 160, 221)); 
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    prepButton.setBackground(new Color(230, 230, 250)); 
                }
            });

            prepButton.addActionListener(e -> JOptionPane.showMessageDialog(this,
                    "- Study consistently\n- Practice past papers\n- Manage time well\n- Review complex topics\n- Stay organized"));

            panel.add(profilePic);
            panel.add(Box.createVerticalStrut(10));
            panel.add(name);
            panel.add(sub);
            panel.add(qual);
            panel.add(exp);
            panel.add(rate);
            panel.add(Box.createVerticalStrut(20));
            panel.add(bookButton);
            panel.add(prepButton);
            gridPanel.add(panel);
        }

        contentPanel.add(gridPanel, BorderLayout.CENTER) ;
        add(contentPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TutorsProfile();
    }
}

