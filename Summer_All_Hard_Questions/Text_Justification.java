package Summer_All_Hard_Questions;

import java.util.ArrayList;
import java.util.List;

public class Text_Justification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		if(words == null || words.length < 1) return res;
		ArrayList<String> buffer = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		int length = 0;
		for(int i = 0; i < words.length; i ++){
			String word = words[i];
			if(word.length() + 1 + length + buffer.size() - 1 <= maxWidth){
				length += word.length();
				buffer.add(word);
			}else{
				String line = generateString(buffer, maxWidth, length);
				res.add(line);
				length = word.length();
				buffer.clear();
				buffer.add(word);
			}
		}
		if(!buffer.isEmpty()){
			builder.setLength(0);
			for(String s: buffer){
				builder.append(s);
				builder.append(" ");
			}
			String line = builder.toString().trim();
			int k = maxWidth - line.length();
			for(int i = 0; i < k; i ++) line += " ";
			res.add(line);
		}
		return res;
    }
	
	private String generateString(ArrayList<String> buffer, int maxWidth, int length){
		int n = maxWidth - length;
		if(buffer.size() == 1){
			int spc = maxWidth - buffer.get(0).length();
			String res = buffer.get(0);
			for(int j = 0; j < spc; j ++) res += " ";
			return res;
		}
		int spc = n / (buffer.size() - 1);
		int k = n % (buffer.size() - 1);
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < buffer.size(); i ++){
			builder.append(buffer.get(i));
			if(i == buffer.size() - 1) continue;
			for(int j = 0; j < spc; j ++) builder.append(" ");
			if(k > 0) {
				builder.append(" ");
				k --;
			}
		}
		return builder.toString();
	}
}
