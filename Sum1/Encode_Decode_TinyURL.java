package Sum1;

import java.util.HashMap;

public class Encode_Decode_TinyURL {
	HashMap<Integer, String> map = new HashMap<>();
	int i = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(i, longUrl);
        return "http://tinyurl.com/" + (i ++);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int num = Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
        return map.get(num);
    }
}
