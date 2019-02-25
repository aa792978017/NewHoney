package com.honeypot.honeypot.util;

import com.honeypot.honeypot.entity.Model;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import java.io.*;

public class BuildXmlUtil {
    final Document document = DocumentHelper.createDocument();
    final Element nodes = document.addElement("nodes");

    public void buildNode(Model model){
        Element node = nodes.addElement("node");
        Element ipNode = node.addElement("ip");
        ipNode.setText(model.getIp());
        Element typeNode = node.addElement("type");
        if(model.getType().equals("复合蜜罐")){
            typeNode.setText("t-pot");
        }else{
            typeNode.setText(model.getType());
        }
        Element serverNode = node.addElement("server");
        serverNode.setText(model.getServer());
        Element serverIdNode = node.addElement("serverId");
        serverIdNode.setText(String.valueOf(model.getServerId()));
        Element serverIpNode = node.addElement("serverIp");
        serverIpNode.setText(model.getServerIp());
    }
    public void buildNode(String domainId,String type,int potId,String serverIp){
        Element node = nodes.addElement("node");
        Element domainIdNode = node.addElement("domainId");
        domainIdNode.setText(domainId);
        Element typeNode = node.addElement("type");
        typeNode.setText(type);
        Element potIdNode = node.addElement("potId");
        potIdNode.setText(String.valueOf(potId));
        Element serverIpNode = node.addElement("serverIp");
        serverIpNode.setText(serverIp);
    }
    public void buildXml(String path){
        org.dom4j.io.OutputFormat format = org.dom4j.io.OutputFormat.createPrettyPrint();
        try {
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(new File(path)), format);
            xmlWriter.write(document);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
