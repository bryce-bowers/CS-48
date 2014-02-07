



class ButtonFrame extends JFrame{
    
    ButtonFrame(String title, String input1, int x1, int y1, 
		String input2, int x2, int y2) {
	
	this.setSize(900,600);
	this.setTitle(title);

	JLabel a = new JLabel(input1);
	a.setBounds(x1,y1,50,50);

	JLabel b = new JLabel(input2);
	b.setBounds(x2,y2,50,50);

}
