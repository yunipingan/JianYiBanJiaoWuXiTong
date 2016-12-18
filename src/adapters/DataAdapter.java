package adapters;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import beans.IMydata;

public class DataAdapter implements IAdapter{
	
	List<JTextArea> jTextAreas;
	List<IMydata> datas;

	public DataAdapter(List<JTextArea> jTextAreas, List<IMydata> datas) {
		super();
		this.jTextAreas = jTextAreas;
		this.datas = datas;
	}

	@Override
	public void loadData(){
		
		System.out.println(datas.size());
		for(int i=0 ; i<datas.size(); i++){
			System.out.println(datas.get(i).getDataText());
			jTextAreas.get(i).setText(datas.get(i).getDataText());
		}
		
	}

}
