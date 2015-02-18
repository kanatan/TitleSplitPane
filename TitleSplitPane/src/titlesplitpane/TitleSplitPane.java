package titlesplitpane;

import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class TitleSplitPane extends JSplitPane {
	JScrollPane titlePane=new JScrollPane();
	JScrollPane contentsPane=new JScrollPane();
	public TitleSplitPane() {
		super(HORIZONTAL_SPLIT);
		setTitleSplitPane();
	}

	public TitleSplitPane(Component newTitleComponent,Component newContentsComponent){
		super(HORIZONTAL_SPLIT);
		setTitleSplitPane();
		setComponent(newTitleComponent, newContentsComponent);
	}

	public TitleSplitPane(int newOrientation) {
		super(newOrientation);
		setTitleSplitPane();
	}

	public TitleSplitPane(int newOrientation, Component newTitleComponent,Component newContentsComponent) {
		super(newOrientation);
		setTitleSplitPane();
		setComponent(newTitleComponent, newContentsComponent);
	}

	private void setTitleSplitPane(){
		titlePane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		titlePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		if(getOrientation()==HORIZONTAL_SPLIT){
			titlePane.getVerticalScrollBar().setModel(contentsPane.getVerticalScrollBar().getModel());
		}
		else{
			titlePane.getHorizontalScrollBar().setModel(contentsPane.getHorizontalScrollBar().getModel());
		}
	}

	public void setComponent(Component newTitleComponent,Component newContentsComponent){
		setTitleComponent(newTitleComponent);
		setContentsComponent(newContentsComponent);
	}

	public void setTitleComponent(Component newTitleComponent){
		titlePane.setViewportView(newTitleComponent);
	}

	public void setContentsComponent(Component newContentsComponent){
		contentsPane.setViewportView(newContentsComponent);
	}
}
