package cn.zhouyafeng.wechat.component;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkHttpClient工具类
 * 
 * @author https://github.com/yaphone
 * @date 创建时间：2017年5月24日 上午12:11:34
 * @version 1.0
 *
 */
@Component
public class MyOkHttpClient {
	private static Logger LOG = LoggerFactory.getLogger(MyOkHttpClient.class);

	private static OkHttpClient client = new OkHttpClient();

	/**
	 * okHttp get请求
	 * 
	 * @date 2017年5月24日 上午12:14:44
	 * @param url
	 * @param paramsMap
	 * @return
	 */
	public Response doGet(String url, HashMap<String, String> params) {
		HttpUrl.Builder httpBuider = HttpUrl.parse(url).newBuilder();
		if (params != null) {
			for (Map.Entry<String, String> param : params.entrySet()) {
				httpBuider.addQueryParameter(param.getKey(), param.getValue());
			}
		}
		Request request = new Request.Builder().url(httpBuider.build()).build();
		// Request request = new Request.Builder().url(url).build();
		Call call = client.newCall(request);
		try {
			Response response = call.execute();
			return response;
		} catch (Exception e) {
			LOG.debug(e.getMessage());
		}
		return null;
	}

}
