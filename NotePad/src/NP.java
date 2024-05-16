import javax.swing.*;
import java.awt.event.*;

public class NP implements ActionListener {
	
	JFrame f;
	JMenuBar mb;
	JMenu file, edit, help;
	JMenuItem cut, copy, paste, selectAll;
	JTextArea ta;
	
	NP(){
		f = new JFrame();
		cut = new JMenuItem("cut");
		copy = new JMenuItem("copy");
		paste = new JMenuItem("paste");
		selectAll = new JMenuItem("selectAll");
		
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		selectAll.addActionListener(this);
		
		mb = new JMenuBar();
		file = new JMenu("File");
		edit = new JMenu("Edit");
		help = new JMenu("Help");
		
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(selectAll);
		
		file.add(new JMenuItem("New"));
		file.add(new JMenuItem("Open File"));
		file.add(new JMenuItem("Save"));
		file.add(new JMenuItem("SaveAs")); //FileHandling
		
		mb.add(file);
		mb.add(edit);
		mb.add(help);
		
		ta = new JTextArea();
		ta.setBounds(5, 5, 360, 320);
		
		f.add(mb);
		f.add(ta);
		f.setJMenuBar(mb);
		f.setLayout(null);
		f.setSize(400,400);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cut)
			ta.cut();
		if(e.getSource()==paste)
			ta.paste();
		if(e.getSource()==copy)
			ta.copy();
		if(e.getSource()==selectAll)
			ta.selectAll();
		
	}

	public static void main(String[] args) {
		new NP();
	}

}
