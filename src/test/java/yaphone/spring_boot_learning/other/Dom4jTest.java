package yaphone.spring_boot_learning.other;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jTest {
	public static void main(String[] args) throws DocumentException {
		SAXReader saxReader = new SAXReader();
		String path = "D://itchat4j/pic/msg.xml";
		File file = new File(path);
		Document document = saxReader.read(file);

		// 获取根节点
		Element root = document.getRootElement();
		System.out.println("Root: " + root.getName());

		// 获取所有子元素
		List<Element> childList = root.elements();
		System.out.println("total child count: " + childList.size());

		// 获取ToUserName
		Element toUserNameElement = root.element("ToUserName");
		System.out.println(toUserNameElement.getData());

		// 获取FromUserName
		Element fromUserNameElement = root.element("FromUserName");
		System.out.println(fromUserNameElement.getData());

		// 获取CreateTime
		Element createTimeElement = root.element("CreateTime");
		System.out.println(createTimeElement.getData());

		// 获取MsgType
		Element msgTypeElement = root.element("MsgType");
		System.out.println(msgTypeElement.getData());

		// 获取Content
		Element contentElement = root.element("Content");
		System.out.println(contentElement.getData());

		// 获取MsgId
		Element msgIdElement = root.element("MsgId");
		System.out.println(msgIdElement.getData());

	}

}
