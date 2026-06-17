    import javax.swing.JFrame;
    import java.util.ArrayList;
    import javax.swing.JButton;
    import javax.swing.JLabel;
    import javax.swing.JTextField;
    import javax.swing.JComboBox;
    import javax.swing.JRadioButton;
    import javax.swing.ButtonGroup;
    import javax.swing.JPanel;
    import java.awt.event.ActionListener;
    import java.awt.event.ActionEvent;
    import javax.swing.JOptionPane;
    import javax.swing.JTextArea;
    import javax.swing.JScrollPane;
    import java.awt.Font;
    import java.awt.Color;
    import java.io.FileWriter;
    import java.io.BufferedWriter;
    import java.io.FileReader;
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.awt.BorderLayout;
    
    public class GymGUI {
        JFrame frame;
        JPanel mainPanel, rPanel, pPanel, displayPanel;
        JLabel title, regularLabel, id, name, location, phone, email, gender, dob,
        membershipStDate, referralSource, upgradePlan,removalreason, price, paidAmt, discount,
        premiumLabel,idp,namep,locationp,phonep,emailp,genderp,dobp,membershipStDatep,removalreasonp,
        pricep,pricevaluep,paidAmtp,discountp,personalTrainerp;
        // Initialize the text fields here to prevent null pointer exceptions
        JTextField idfield = new JTextField();
        JTextField namefield = new JTextField();
        JTextField locationfield = new JTextField();
        JTextField phonefield = new JTextField();
        JTextField emailfield = new JTextField();
        JTextField referralSourcefield = new JTextField();
        JTextField paidAmtfield = new JTextField();
        JTextField pricefield=new JTextField();
        JTextField removalreasonfield=new JTextField();
        JTextField idpfield = new JTextField();
        JTextField namepfield = new JTextField();
        JTextField locationpfield = new JTextField();
        JTextField phonepfield = new JTextField();
        JTextField emailpfield = new JTextField();
        JTextField paidAmtpfield = new JTextField();
        JTextField removalreasonpfield=new JTextField();
        JTextField personalTrainerpfield=new JTextField();
        JRadioButton maleRadioButton, femaleRadioButton, maleRadioButtonp,femaleRadioButtonp;
        JComboBox<String> dobYear, dobMonth, dobDay, plan, startYear, startMonth, startDay,
        dobYearp,dobMonthp,dobDayp,startYearp,startMonthp,startDayp;
        ArrayList<String> regularMembers;
        ArrayList<String> premiumMembers;
        ArrayList<GymMember> membersList;
    
        public static void main (String[]args){
            new GymGUI();
        }
    
        private void clearfields(){
            idfield.setText("");
            namefield.setText("");
            locationfield.setText("");
            phonefield.setText("");
            emailfield.setText("");
            referralSourcefield.setText("");
            paidAmtfield.setText("");
            dobYear.setSelectedIndex(0);
            dobMonth.setSelectedIndex(0);
            dobDay.setSelectedIndex(0);
            startYear.setSelectedIndex(0);
            startMonth.setSelectedIndex(0);
            startDay.setSelectedIndex(0);
    
            idpfield.setText("");
            namepfield.setText("");
            locationpfield.setText("");
            phonepfield.setText("");
            emailpfield.setText("");
            paidAmtpfield.setText("");
            removalreasonpfield.setText("");
            personalTrainerpfield.setText("");
            dobYearp.setSelectedIndex(0);
            dobMonthp.setSelectedIndex(0);
            dobDayp.setSelectedIndex(0);
            startYearp.setSelectedIndex(0);
            startMonthp.setSelectedIndex(0);
            startDayp.setSelectedIndex(0);
        }
    
        public GymGUI() {
            regularMembers = new ArrayList<>();
            premiumMembers = new ArrayList<>();
            membersList = new ArrayList<>();
    
            frame = new JFrame("GUI");
            frame.setSize(800, 800);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
    
            mainPanel = new JPanel();
            mainPanel.setBounds(0, 0, 800, 800);
            mainPanel.setLayout(null);
            mainPanel.setVisible(true);
    
            rPanel = new JPanel();
            rPanel.setBounds(0, 0, 800, 800);
            rPanel.setLayout(null);
            rPanel.setVisible(false);
    
            pPanel = new JPanel();
            pPanel.setBounds(0, 0, 800, 800);
            pPanel.setLayout(null);
            pPanel.setVisible(false);
    
            displayPanel = new JPanel();
            displayPanel.setBounds(0, 0, 800, 800);
            displayPanel.setLayout(null);
            displayPanel.setVisible(false);
    
            frame.add(mainPanel);
            frame.add(rPanel);
            frame.add(pPanel);
            frame.add(displayPanel);
    
            setupMainPanel();
            setuprPanel();
    
            setuppPanel();
    
            setupdisplayPanel();
    
            frame.setVisible(true);
        }
    
        private void setupMainPanel() {
            mainPanel.setBackground(new java.awt.Color(52,70,70)); 
    
            title = new JLabel("GYM MEMBERSHIP SYSTEM");
            title.setForeground(Color.WHITE);
            title.setFont(new Font("Montserrat", Font.BOLD, 30));
    
            JButton addRegularButton = new JButton("Add a Regular Member");
            JButton addPremiumButton = new JButton("Add a Premium Member");
            JButton showMembersButton = new JButton("Show Members");
    
            title.setBounds(200, 80, 500, 80);
            mainPanel.add(title);
            addRegularButton.setBounds(300, 200, 200, 40);
            mainPanel.add(addRegularButton);
            addPremiumButton.setBounds(300, 300, 200, 40);
            mainPanel.add(addPremiumButton);
            showMembersButton.setBounds(300, 400, 200, 40);
            mainPanel.add(showMembersButton);
    
            addRegularButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        mainPanel.setVisible(false);
                        rPanel.setVisible(true);
                        pPanel.setVisible(false);
                        displayPanel.setVisible(false);
                    }
                });
            addPremiumButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        mainPanel.setVisible(false);
                        rPanel.setVisible(false);
                        pPanel.setVisible(true);
                        displayPanel.setVisible(false);
                    }
                });
            showMembersButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        mainPanel.setVisible(false);
                        rPanel.setVisible(false);
                        pPanel.setVisible(false);
                        displayPanel.setVisible(true);
                    }
                });
        }
    
        private void setuprPanel() {
            regularLabel = new JLabel("REGULAR MEMBER REGISTRATION");
            regularLabel.setFont(new Font("Montserrat", Font.BOLD, 20));
            regularLabel.setBounds(230, 20, 400, 80);
            rPanel.add(regularLabel);
    
            id = new JLabel("ID:");
            id.setBounds(40, 80, 100, 50);
            rPanel.add(id);
            idfield.setBounds(100, 100, 280, 20);
            rPanel.add(idfield);
    
            name = new JLabel("Name:");
            name.setBounds(40, 110, 100, 50);
            rPanel.add(name);
            namefield.setBounds(100, 130, 280, 20);
            rPanel.add(namefield);
    
            location = new JLabel("Location:");
            location.setBounds(40, 140, 100, 50);
            rPanel.add(location);
            locationfield.setBounds(100, 160, 280, 20);
            rPanel.add(locationfield);
    
            phone = new JLabel("Phone:");
            phone.setBounds(40, 170, 100, 50);
            rPanel.add(phone);
            phonefield.setBounds(100, 190, 280, 20);
            rPanel.add(phonefield);
    
            email = new JLabel("Email:");
            email.setBounds(40, 200, 100, 50);
            rPanel.add(email);
            emailfield.setBounds(100, 220, 280, 20);
            rPanel.add(emailfield);
    
            gender = new JLabel("Gender:");
            gender.setBounds(40, 230, 100, 50);
            rPanel.add(gender);
    
            // Initialize radio buttons
            maleRadioButton = new JRadioButton("Male");
            femaleRadioButton = new JRadioButton("Female");
            maleRadioButton.setBounds(100, 245, 80, 20);
            femaleRadioButton.setBounds(190, 245, 80, 20);
    
            // Create button group to ensure only one radio button can be selected
            ButtonGroup genderGroup = new ButtonGroup();
            genderGroup.add(maleRadioButton);
            genderGroup.add(femaleRadioButton);
    
            rPanel.add(maleRadioButton);
            rPanel.add(femaleRadioButton);
    
            dob = new JLabel("DOB:");
            dob.setBounds(40, 260, 100, 50);
            rPanel.add(dob);
    
            // Initialize date components
            String[] years = getYears();
            String[] months = {"January", "February", "March", "April", "May", "June", 
                    "July", "August", "September", "October", "November", "December"};
            String[] days = getDays();
    
            dobYear = new JComboBox<>(years);
            dobMonth = new JComboBox<>(months);
            dobDay = new JComboBox<>(days);
    
            dobYear.setBounds(100, 275, 90, 20);
            dobMonth.setBounds(200, 275, 100, 20);
            dobDay.setBounds(310, 275, 70, 20);
    
            rPanel.add(dobYear);
            rPanel.add(dobMonth);
            rPanel.add(dobDay);
    
            membershipStDate = new JLabel("Membership Start Date:");
            membershipStDate.setBounds(40, 290, 150, 50);
            rPanel.add(membershipStDate);
    
            startYear = new JComboBox<>(years);
            startMonth = new JComboBox<>(months);
            startDay = new JComboBox<>(days);
    
            startYear.setBounds(190, 305, 90, 20);
            startMonth.setBounds(290, 305, 100, 20);
            startDay.setBounds(400, 305, 70, 20);
    
            rPanel.add(startYear);
            rPanel.add(startMonth);
            rPanel.add(startDay);
    
            referralSource = new JLabel("Referral Source:");
            referralSource.setBounds(40, 320, 100, 50);
            rPanel.add(referralSource);
            referralSourcefield.setBounds(150, 335, 280, 20);
            rPanel.add(referralSourcefield);
    
            upgradePlan = new JLabel("Upgrade Plan:");
            upgradePlan.setBounds(40, 350, 100, 50);
            rPanel.add(upgradePlan);
    
            String[] plans = {"Basic", "Deluxe", "Premium"};
            plan = new JComboBox<>(plans);
            plan.setBounds(150, 365, 150, 20);
            rPanel.add(plan);
    
            price = new JLabel("Price:");
            price.setBounds(40, 380, 100, 50);
            rPanel.add(price);
    
            pricefield.setBounds(150,400,200,20);
            rPanel.add(pricefield);
    
            paidAmt = new JLabel("Paid Amount:");
            paidAmt.setBounds(40, 410, 100, 50);
            rPanel.add(paidAmt);
            paidAmtfield.setBounds(150, 425, 280, 20);
            rPanel.add(paidAmtfield);
    
            JLabel removalreason=new JLabel("Removal reason:");
            removalreason.setBounds(40,470,100,50);
            rPanel.add(removalreason);
            removalreasonfield.setBounds(150,490,280,20);
            rPanel.add(removalreasonfield);
    
            JButton addRegularMemberButton = new JButton("Add Regular Member");
            addRegularMemberButton.setBounds(40, 540, 200, 30);
            rPanel.add(addRegularMemberButton);
    
            JButton activateMembershipButton = new JButton("Activate Membership");
            activateMembershipButton.setBounds(260, 540, 200, 30);
            rPanel.add(activateMembershipButton);
    
            JButton deactivateMembershipButton = new JButton("Deactivate Membership");
            deactivateMembershipButton.setBounds(480, 540, 200, 30);
            rPanel.add(deactivateMembershipButton);
    
            JButton markAttendanceButton = new JButton("Mark Attendance");
            markAttendanceButton.setBounds(40, 580, 200, 30);
            rPanel.add(markAttendanceButton);
    
            JButton upgradePlanButton = new JButton("Upgrade Plan");
            upgradePlanButton.setBounds(260, 580, 200, 30);
            rPanel.add(upgradePlanButton);
    
            JButton revertRegularMemberButton = new JButton("Revert Regular Member");
            revertRegularMemberButton.setBounds(480, 580, 200, 30);
            rPanel.add(revertRegularMemberButton);
    
            JButton clearButton = new JButton("Clear");
            clearButton.setBounds(480, 620, 200, 30);
            rPanel.add(clearButton);
    
            JButton saveToFileButton = new JButton("Save to File");
            saveToFileButton.setBounds(40, 620, 200, 30);
            rPanel.add(saveToFileButton);
    
            JButton readFromFileButton = new JButton("Read from File"); 
            readFromFileButton.setBounds(260, 620, 200, 30); 
            rPanel.add(readFromFileButton);
    
    
            // Add a back button to return to main panel
            JButton backButton = new JButton("Back to Main Menu");
            backButton.setBounds(300, 700, 200, 30);
            rPanel.add(backButton);
    
            backButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        rPanel.setVisible(false);
                        mainPanel.setVisible(true);
                    }
                });
    
            plan.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String selectedPlan = (String) plan.getSelectedItem();
                        if (selectedPlan.equals("Basic")) {
                            pricefield.setText("6500");
                        } else if (selectedPlan.equals("Standard")) {
                            pricefield.setText("12500");
                        } else if (selectedPlan.equals("Deluxe")) {
                            pricefield.setText("18500");
                        }
                    }
                });
    
            // Add action listeners for buttons
            addRegularMemberButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                        int id = Integer.parseInt(idfield.getText());
                        
                        if (id <= 0) {
                            JOptionPane.showMessageDialog(frame, "Member ID must be greater than 0!");
                            return;
                        }
                            String name = namefield.getText();
                            String location = locationfield.getText();
                            String phone = phonefield.getText();
                            String email = emailfield.getText();
                            if (phone.length() != 10 || !phone.matches("\\d{10}")) {
                            JOptionPane.showMessageDialog(frame, "Phone number must be exactly 10 digits!");
                            return;
                        }
                            String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                            //String dob = dobYear.getText();
                            //String startDate = membershipStartField.getText();
                            String referral = referralSourcefield.getText();
    
                            // Check for duplicate ID
                            for (GymMember member : (membersList)){
                                if (member.getId() == id) {
                                    JOptionPane.showMessageDialog(frame, "Member ID already exists!");
                                    return;
                                }
                            }
    
                            // Get the date from the dropdowns
                            String dobString = dobYear.getSelectedItem() + "-" + dobMonth.getSelectedItem() + "-" + dobDay.getSelectedItem();
                            String startDateString = startYear.getSelectedItem() + "-" + startMonth.getSelectedItem() + "-" + startDay.getSelectedItem();
                            // Create new RegularMember and add to list
                            RegularMember newMember = new RegularMember(id, name, location, phone, email, gender, dobString,startDateString, referral);
                            membersList.add(newMember);
    
                            JOptionPane.showMessageDialog(frame, "Regular Member added successfully!");
                            clearfields();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for ID.");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                        }
                    }
                });
    
            activateMembershipButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int id = Integer.parseInt(idfield.getText());
                            boolean found = false;
    
                            for (GymMember member : membersList) {
                                if (member.getId() == id) {
                                    member.activateMembership();
                                    JOptionPane.showMessageDialog(frame, "Membership activated successfully!");
                                    found = true;
                                    break;
                                }
                            }
    
                            if (!found) {
                                JOptionPane.showMessageDialog(frame, "Member ID not found!");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for ID.");
                        }
                    }
                });
    
            deactivateMembershipButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int id = Integer.parseInt(idfield.getText());
                            boolean found = false;
    
                            for (GymMember member : membersList) {
                                if (member.getId() == id) {
                                    member.deactivateMembership();
                                    JOptionPane.showMessageDialog(frame, "Membership deactivated successfully!");
                                    found = true;
                                    break;
                                }
                            }
    
                            if (!found) {
                                JOptionPane.showMessageDialog(frame, "Member ID not found!");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for ID.");
                        }
                    }
                });
    
            markAttendanceButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int id = Integer.parseInt(idfield.getText());
                            boolean found = false;
    
                            for (GymMember member : membersList) {
                                if (member.getId() == id) {
                                    if (member.activeStatus()) {
                                        member.markAttendance();
                                        JOptionPane.showMessageDialog(frame, "Attendance marked successfully!");
                                    } else {
                                        JOptionPane.showMessageDialog(frame, "Member is not active. Cannot mark attendance.");
                                    }
                                    found = true;
                                    break;
                                }
                            }
    
                            if (!found) {
                                JOptionPane.showMessageDialog(frame, "Member ID not found!");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for ID.");
                        }
                    }
                });
    
            upgradePlanButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int id = Integer.parseInt(idfield.getText());
                            String selectedPlan = (String) plan.getSelectedItem();
                            boolean found = false;
    
                            for (GymMember member : membersList) {
                                if (member.getId() == id) {
                                    if (member instanceof RegularMember) {
                                        if (member.activeStatus()) {
                                            RegularMember regMember = (RegularMember) member;
                                            String result = regMember.upgradePlan(selectedPlan);
                                            JOptionPane.showMessageDialog(frame, result);
                                        } else {
                                            JOptionPane.showMessageDialog(frame, "Member is not active. Cannot upgrade plan.");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(frame, "This member is not a Regular Member!");
                                    }
                                    found = true;
                                    break;
                                }
                            }
    
                            if (!found) {
                                JOptionPane.showMessageDialog(frame, "Member ID not found!");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for ID.");
                        }
                    }
                });
    
            revertRegularMemberButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int id = Integer.parseInt(idfield.getText());
                            String reason = removalreasonfield.getText();
                            boolean found = false;
    
                            for (GymMember member : membersList) {
                                if (member.getId() == id) {
                                    if (member instanceof RegularMember) {
                                        RegularMember regularMember = (RegularMember) member;
                                        regularMember.revertRegularMember(reason);
                                        JOptionPane.showMessageDialog(frame, "Regular Member reverted successfully!");
                                    } else {
                                        JOptionPane.showMessageDialog(frame, "This member is not a Regular Member!");
                                    }
                                    found = true;
                                    break;
                                }
                            }
    
                            if (!found) {
                                JOptionPane.showMessageDialog(frame, "Member ID not found!");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter a valid numeric Member ID.");
                        }
                    }
                });
    
            clearButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        clearfields();
                    }
                });
            saveToFileButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        saveToFile();
                    }
                });
    
            readFromFileButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        readFromFile();
                    }
                });
        }
    
        // Helper method to generate years for dropdown
        private String[] getYears() {
            String[] years = new String[100];
            int currentYear = 2025;
            for (int i = 0; i < years.length; i++) {
                years[i] = String.valueOf(currentYear - i);
            }
            return years;
        }
    
        // Helper method to generate days for dropdown
        private String[] getDays() {
            String[] days = new String[31];
            for (int i = 0; i < days.length; i++) {
                days[i] = String.valueOf(i + 1);
            }
            return days;
        }
    
        private void setuppPanel() {
            premiumLabel = new JLabel("PREMIUM MEMBER REGISTRATION");
            premiumLabel.setFont(new Font("Montserrat", Font.BOLD, 20));
            premiumLabel.setBounds(230, 20, 400, 80);
            pPanel.add(premiumLabel);
    
            idp = new JLabel("ID:");
            idp.setBounds(40, 80, 100, 50);
            pPanel.add(idp);
            idpfield.setBounds(100, 100, 280, 20);
            pPanel.add(idpfield);
    
            namep = new JLabel("Name:");
            namep.setBounds(40, 110, 100, 50);
            pPanel.add(namep);
            namepfield.setBounds(100, 130, 280, 20);
            pPanel.add(namepfield);
    
            locationp = new JLabel("Location:");
            locationp.setBounds(40, 140, 100, 50);
            pPanel.add(locationp);
            locationpfield.setBounds(100, 160, 280, 20);
            pPanel.add(locationpfield);
    
            phonep = new JLabel("Phone:");
            phonep.setBounds(40, 170, 100, 50);
            pPanel.add(phonep);
            phonepfield.setBounds(100, 190, 280, 20);
            pPanel.add(phonepfield);
    
            emailp = new JLabel("Email:");
            emailp.setBounds(40, 200, 100, 50);
            pPanel.add(emailp);
            emailpfield.setBounds(100, 220, 280, 20);
            pPanel.add(emailpfield);
    
            genderp = new JLabel("Gender:");
            genderp.setBounds(40, 230, 100, 50);
            pPanel.add(genderp);
    
            // Initialize radio buttons
            maleRadioButtonp = new JRadioButton("Male");
            femaleRadioButtonp = new JRadioButton("Female");
            maleRadioButtonp.setBounds(100, 245, 80, 20);
            femaleRadioButtonp.setBounds(190, 245, 80, 20);
    
            // Create button group to ensure only one radio button can be selected
            ButtonGroup genderpGroup = new ButtonGroup();
            genderpGroup.add(maleRadioButtonp);
            genderpGroup.add(femaleRadioButtonp);
    
            pPanel.add(maleRadioButtonp);
            pPanel.add(femaleRadioButtonp);
    
            dobp = new JLabel("DOB:");
            dobp.setBounds(40, 260, 100, 50);
            pPanel.add(dobp);
    
            // Initialize date components
            String[] years = getYearsp();
            String[] months = {"January", "February", "March", "April", "May", "June", 
                    "July", "August", "September", "October", "November", "December"};
            String[] days = getDaysp();
    
            dobYearp = new JComboBox<>(years);
            dobMonthp = new JComboBox<>(months);
            dobDayp = new JComboBox<>(days);
    
            dobYearp.setBounds(100, 275, 90, 20);
            dobMonthp.setBounds(200, 275, 100, 20);
            dobDayp.setBounds(310, 275, 70, 20);
    
            pPanel.add(dobYearp);
            pPanel.add(dobMonthp);
            pPanel.add(dobDayp);
    
            membershipStDatep = new JLabel("Membership Start Date:");
            membershipStDatep.setBounds(40, 290, 150, 50);
            pPanel.add(membershipStDatep);
    
            startYearp = new JComboBox<>(years);
            startMonthp = new JComboBox<>(months);
            startDayp = new JComboBox<>(days);
    
            startYearp.setBounds(190, 305, 90, 20);
            startMonthp.setBounds(290, 305, 100, 20);
            startDayp.setBounds(400, 305, 70, 20);
    
            pPanel.add(startYearp);
            pPanel.add(startMonthp);
            pPanel.add(startDayp);
    
            personalTrainerp = new JLabel("Personal Trainer:");
            personalTrainerp.setBounds(40, 320, 100, 50);
            pPanel.add(personalTrainerp);
            personalTrainerpfield.setBounds(150, 335, 280, 20);
            pPanel.add(personalTrainerpfield);
    
            pricep = new JLabel("Price:");
            pricep.setBounds(40, 380, 100, 50);
            pPanel.add(pricep);
    
            pricevaluep=new JLabel("50,000");
            pricevaluep.setBounds(150,400,200,20);
            pPanel.add(pricevaluep);
    
            paidAmtp = new JLabel("Paid Amount:");
            paidAmtp.setBounds(40, 410, 100, 50);
            pPanel.add(paidAmtp);
            paidAmtpfield.setBounds(150, 425, 280, 20);
            pPanel.add(paidAmtpfield);
    
            discountp = new JLabel("Discount:");
            discountp.setBounds(40, 440, 100, 50);
            pPanel.add(discountp);
    
            JLabel removalreasonp=new JLabel("Removal reason:");
            removalreasonp.setBounds(40,470,100,50);
            pPanel.add(removalreasonp);
            removalreasonpfield.setBounds(150,490,280,20);
            pPanel.add(removalreasonpfield);
    
            JButton addPremiumMemberButton = new JButton("Add Premium Member");
            addPremiumMemberButton.setBounds(40, 540, 200, 30);
            pPanel.add(addPremiumMemberButton);
    
            JButton activateMembershipButtonp = new JButton("Activate Membership");
            activateMembershipButtonp.setBounds(260, 540, 200, 30);
            pPanel.add(activateMembershipButtonp);
    
            JButton deactivateMembershipButtonp = new JButton("Deactivate Membership");
            deactivateMembershipButtonp.setBounds(480, 540, 200, 30);
            pPanel.add(deactivateMembershipButtonp);
    
            JButton markAttendanceButtonp = new JButton("Mark Attendance");
            markAttendanceButtonp.setBounds(40, 580, 200, 30);
            pPanel.add(markAttendanceButtonp);
    
            JButton revertPremiumMemberButton = new JButton("Revert Premium Member");
            revertPremiumMemberButton.setBounds(480, 580, 200, 30);
            pPanel.add(revertPremiumMemberButton);
    
            JButton clearButtonp = new JButton("Clear");
            clearButtonp.setBounds(260, 580, 200, 30);
            pPanel.add(clearButtonp);
    
            JButton saveToFileButtonp = new JButton("Save to File");
            saveToFileButtonp.setBounds(40, 620, 200, 30);
            pPanel.add(saveToFileButtonp);
    
            // Add read from file button 
            JButton readFromFileButtonp = new JButton("Read from File");
            readFromFileButtonp.setBounds(260, 620, 200, 30);
            pPanel.add(readFromFileButtonp);
    
            JButton calculateDiscountButton = new JButton("Calculate Discount");
            calculateDiscountButton.setBounds(160, 450, 200, 30);
            pPanel.add(calculateDiscountButton);
            
            JLabel discountAmountLabel = new JLabel("");
            discountAmountLabel.setBounds(150, 450, 200, 20);
            pPanel.add(discountAmountLabel);
    
            JButton payDueAmountButton = new JButton("Pay Due Amount");
            payDueAmountButton.setBounds(480, 620, 200, 20);
            pPanel.add(payDueAmountButton);
    
            // Add a back button to return to main panel
            JButton backButtonp = new JButton("Back to Main Menu");
            backButtonp.setBounds(300, 700, 200, 30);
            pPanel.add(backButtonp);
    
            backButtonp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        pPanel.setVisible(false);
                        mainPanel.setVisible(true);
                    }
                });
            addPremiumMemberButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try{
                            int idp = Integer.parseInt(idpfield.getText());
                            if (idp <= 0) {
                            JOptionPane.showMessageDialog(frame, "Member ID must be greater than 0!");
                            return;
                        }
                            String namep = namepfield.getText();
                            String locationp = locationpfield.getText();
                            String phonep = phonepfield.getText();
                            String emailp = emailpfield.getText();
                            if (phonep.length() != 10 || !phonep.matches("\\d{10}")) {
                            JOptionPane.showMessageDialog(frame, "Phone number must be exactly 10 digits!");
                            return;
                        }
                            String genderp = maleRadioButtonp.isSelected() ? "Male" : "Female";
                            String personalTrainerp=personalTrainerpfield.getText();
                            //String dob = dobYear.getText();
                            //String startDate = membershipStartField.getText();
    
                            // Check for duplicate ID
                            for (GymMember member : (membersList)){
                                if (member.getId() == idp) {
                                    JOptionPane.showMessageDialog(frame, "Member ID already exists!");
                                    return;
                                }
                            }
    
                            // Get the date from the dropdowns
                            String dobStringp = dobYearp.getSelectedItem() + "-" + dobMonthp.getSelectedItem() + "-" + dobDayp.getSelectedItem();
                            String startDateStringp = startYearp.getSelectedItem() + "-" + startMonthp.getSelectedItem() + "-" + startDayp.getSelectedItem();
                            // Create new RegularMember and add to list
                            PremiumMember newMember = new PremiumMember(idp, namep, locationp, phonep, emailp, genderp, dobStringp, startDateStringp,personalTrainerp);
                            membersList.add(newMember);
    
                            JOptionPane.showMessageDialog(frame, "Premium Member added successfully!");
                            clearfields();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for ID.");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                        }
                    }
                });
    
            activateMembershipButtonp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int idp = Integer.parseInt(idpfield.getText());
                            boolean found = false;
    
                            for (GymMember member : membersList) {
                                if (member.getId() == idp) {
                                    member.activateMembership();
                                    JOptionPane.showMessageDialog(frame, "Membership activated successfully!");
                                    found = true;
                                    break;
                                }
                            }
    
                            if (!found) {
                                JOptionPane.showMessageDialog(frame, "Member ID not found!");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for ID.");
                        }
                    }
                });
    
            deactivateMembershipButtonp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int idp = Integer.parseInt(idpfield.getText());
                            boolean found = false;
    
                            for (GymMember member : membersList) {
                                if (member.getId() == idp) {
                                    member.deactivateMembership();
                                    JOptionPane.showMessageDialog(frame, "Membership deactivated successfully!");
                                    found = true;
                                    break;
                                }
                            }
    
                            if (!found) {
                                JOptionPane.showMessageDialog(frame, "Member ID not found!");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for ID.");
                        }
                    }
                });
    
            markAttendanceButtonp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int idp = Integer.parseInt(idpfield.getText());
                            boolean found = false;
    
                            for (GymMember member : membersList) {
                                if (member.getId() == idp) {
                                    if (member.activeStatus()) {
                                        member.markAttendance();
                                        JOptionPane.showMessageDialog(frame, "Attendance marked successfully!");
                                    } else {
                                        JOptionPane.showMessageDialog(frame, "Member is not active. Cannot mark attendance.");
                                    }
                                    found = true;
                                    break;
                                }
                            }
    
                            if (!found) {
                                JOptionPane.showMessageDialog(frame, "Member ID not found!");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for ID.");
                        }
                    }
                });
                
                
    
            calculateDiscountButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int id = Integer.parseInt(idpfield.getText());
                            boolean found = false;
    
                            for (GymMember member : membersList) {
                                if (member.getId() == id) {
                                    if (member instanceof PremiumMember) {
                                        PremiumMember premiumMember = (PremiumMember) member;
                                        double standardPrice = 50000;
                                        double discount = standardPrice * 0.10;
                                        double discountedPrice = standardPrice - discount;
                                        
                                        JOptionPane.showMessageDialog(frame, 
                                        "Discount Calculation:\n" +
                                        "Original Price: 50,000\n" +
                                        "Discount (10%): " + discount + "\n" +
                                        "Price after discount: " + discountedPrice);
                                    } else {
                                        JOptionPane.showMessageDialog(frame, "This member is not a Premium Member!");
                                    }
                                    found = true;
                                    break;
                                }
                            }
    
                            if (!found) {
                                JOptionPane.showMessageDialog(frame, "Member ID not found!");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter a valid numeric Member ID.");
                        }
                    }
                });    
    
            payDueAmountButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int idp = Integer.parseInt(idpfield.getText());
                            double payment = Double.parseDouble(paidAmtpfield.getText());
                            boolean found = false;
    
                            for (GymMember member : membersList) {
                                //here
                               if (member.getId() == idp) {
                                    if (member instanceof PremiumMember) {
                                        PremiumMember premiumMember = (PremiumMember) member;
                                        String result = premiumMember.payDueAmount(payment);
                                        JOptionPane.showMessageDialog(frame, result);
                                          if (premiumMember.getIsFullPayment()) {
                            discountp.setText("Discount: " + premiumMember.getDiscountAmount());
                        } else {
                            discountp.setText("Discount: 0.0");
                        }
                                    } else {
                                        JOptionPane.showMessageDialog(frame, "This member is not a Premium Member!");
                                    }
                                    found = true;
                                    break;
                                }
                            }
    
                            if (!found) {
                                JOptionPane.showMessageDialog(frame, "Member ID not found!");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for Member ID and Payment.");
                        }
                    }
                });
    
            revertPremiumMemberButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int id = Integer.parseInt(idpfield.getText());
                            String reason = removalreasonpfield.getText();
                            boolean found = false;
    
                            for (GymMember member : membersList) {
                                if (member.getId() == id) {
                                    if (member instanceof PremiumMember) {
                                        PremiumMember premiumMember = (PremiumMember) member;
                                        premiumMember.revertPremiumMember();
                                        JOptionPane.showMessageDialog(frame, "Premium Member reverted successfully!");
                                    } else {
                                        JOptionPane.showMessageDialog(frame, "This member is not a Premium Member!");
                                    }
                                    found = true;
                                    break;
                                }
                            }
    
                            if (!found) {
                                JOptionPane.showMessageDialog(frame, "Member ID not found!");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter a valid numeric Member ID.");
                        }
                    }
                });
    
            clearButtonp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        clearfields();
                    }
                });
    
            saveToFileButtonp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        saveToFile();
                    }
                });
    
            readFromFileButtonp.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        readFromFile();
                    }
                });
        }
    
        // Helper method to generate years for dropdown
        private String[] getYearsp() {
            String[] years = new String[100];
            int currentYear = 2025;
            for (int i = 0; i < years.length; i++) {
                years[i] = String.valueOf(currentYear - i);
            }
            return years;
        }
    
        // Helper method to generate days for dropdown
        private String[] getDaysp() {
            String[] days = new String[31];
            for (int i = 0; i < days.length; i++) {
                days[i] = String.valueOf(i + 1);
            }
            return days;
        }
    
        private void setupdisplayPanel() {
            // Title
            JLabel title = new JLabel("All Gym Members");
            title.setBounds(300, 20, 200, 30);
            displayPanel.add(title);
    
            // Text area to display members
            JTextArea membersArea = new JTextArea();
            membersArea.setEditable(false);
            JScrollPane scroll = new JScrollPane(membersArea);
            scroll.setBounds(50, 60, 700, 600);
            displayPanel.add(scroll);
    
            // Refresh button
            JButton refreshBtn = new JButton("Refresh");
            refreshBtn.setBounds(300, 680, 100, 30);
            displayPanel.add(refreshBtn);
    
            JButton saveToFileButtond = new JButton("Save to File");
            saveToFileButtond.setBounds(200, 680, 100, 30);
            displayPanel.add(saveToFileButtond);
    
            // Add read from file button
            JButton readFromFileButtond = new JButton("Read from File");
            readFromFileButtond.setBounds(550, 680, 100, 30);
            displayPanel.add(readFromFileButtond);
    
            // Back button
            JButton backBtn = new JButton("Back");
            backBtn.setBounds(420, 680, 100, 30);
            displayPanel.add(backBtn);
    
            // Display members when panel opens
            showAllMembers(membersArea);
    
            // Add action listeners for the new buttons
            saveToFileButtond.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        saveToFile();
                    }
                });
    
            readFromFileButtond.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        readFromFile();
                    }
                });
        }
    
        private void showAllMembers(JTextArea area) {
            StringBuilder sb = new StringBuilder();
    
            if (membersList.isEmpty()) {
                sb.append("No members registered yet.\n");
            } else {
                sb.append("Regular Members\n");
                for (GymMember member : membersList) {
                    if (member instanceof RegularMember) {
                        RegularMember rm = (RegularMember) member;
                        sb.append("ID: ").append(rm.getId()).append("\n");
                        sb.append("Name: ").append(rm.getName()).append("\n");
                        sb.append("Plan: ").append(rm.getPlan()).append("\n");
                        sb.append("Status: ").append(rm.activeStatus() ? "Active" : "Inactive").append("\n\n");
                    }
                }
    
                sb.append("Premium Members\n");
                for (GymMember member : membersList) {
                    if (member instanceof PremiumMember) {
                        PremiumMember pm = (PremiumMember) member;
                        sb.append("ID: ").append(pm.getId()).append("\n");
                        sb.append("Name: ").append(pm.getName()).append("\n");
                        sb.append("Status: ").append(pm.activeStatus() ? "Active" : "Inactive").append("\n\n");
                    }
                }
            }
    
            area.setText(sb.toString());
        }
    
        private void saveToFile() {
            try {
                FileWriter fileWriter = new FileWriter("members.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    
                // Write header
                bufferedWriter.write(String.format("%-5s %-15s %-15s %-15s %-25s %-10s %-20s %-15s %-10s %-15s %-10s %-15s %-15s %-15s\n", 
                        "ID", "Name", "Location", "Phone", "Email", "Gender", "Membership Start Date", 
                        "Plan", "Price", "Attendance", "Loyalty Points", "Active Status", "Full Payment", "Paid Amount"));
    
                // Write member details
                for (GymMember member : membersList) {
                    if (member instanceof RegularMember) {
                        RegularMember rm = (RegularMember) member;
                        bufferedWriter.write(String.format("%-5d %-15s %-15s %-15s %-25s %-10s %-20s %-15s %-10.2f %-10d %-15.2f %-10s %-15s %-15s\n",
                                rm.getId(), rm.getName(), rm.location(), rm.phone(), rm.email(),
                                rm.gender(), rm.membershipStartDate(), rm.getPlan(), rm.getPrice(),
                                rm.attendance(), rm.loyaltyPoints(), rm.activeStatus() ? "Active" : "Inactive",
                                "N/A", "N/A"));
                    } else if (member instanceof PremiumMember) {
                        PremiumMember pm = (PremiumMember) member;
                        bufferedWriter.write(String.format("%-5d %-15s %-15s %-15s %-25s %-10s %-20s %-15s %-10s %-10d %-15.2f %-10s %-15s %-15.2f\n",
                                pm.getId(), pm.getName(), pm.location(), pm.phone(), pm.email(),
                                pm.gender(), pm.membershipStartDate(), "Premium", "50000.00",
                                pm.attendance(), pm.loyaltyPoints(), pm.activeStatus() ? "Active" : "Inactive",
                                pm.isFullPayment? "Yes":"No", pm.paidAmount));
                    }else{
                        continue;
                    }
    
                }
    
                bufferedWriter.close();
                JOptionPane.showMessageDialog(frame, "Member details saved to members.txt successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(frame, "Error saving to file: " + e.getMessage());
            }
        }
    
        // Method to read members from file and display
        private void readFromFile() {
            JFrame readFrame = new JFrame("Members from File");
            readFrame.setSize(800, 600);
            readFrame.setLayout(new BorderLayout());
    
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
    
            try {
                FileReader fileReader = new FileReader("members.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
    
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
    
                bufferedReader.close();
            } catch (IOException e) {
                textArea.setText("Error reading file: " + e.getMessage());
            }
    
            readFrame.add(scrollPane, BorderLayout.CENTER);
    
            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        readFrame.dispose();
                    }
                });
    
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(closeButton);
            readFrame.add(buttonPanel, BorderLayout.SOUTH);
    
            readFrame.setVisible(true);
        }
    
    }