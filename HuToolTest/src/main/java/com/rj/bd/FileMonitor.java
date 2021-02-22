package com.rj.bd;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.WatchEvent;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.Watcher;

/**
 * 文件监听
 * @author XQ
 *
 */
public class FileMonitor {
	public static void main(String[] args) {
		String filea = "e:/qrcodeFile";
		File file = FileUtil.file(filea);
		/**
		 *  ENTRY_MODIFY 文件修改的事件
		 *	ENTRY_CREATE 文件或目录创建的事件
		 *	ENTRY_DELETE 文件或目录删除的事件
		 *	OVERFLOW 丢失的事件
		 *	EVENTS_ALL 监听全部事件
		 */
		WatchMonitor watchMonitor = WatchMonitor.create(file, WatchMonitor.EVENTS_ALL);
		
		watchMonitor.setWatcher(new Watcher() {
			
			public void onOverflow(WatchEvent<?> event, Path currentPath) {
				Object obj = event.context();
				System.out.println("Overflow事件启动... 目录地址："+currentPath+obj);
				
			}
			
			public void onModify(WatchEvent<?> event, Path currentPath) {
				Object obj = event.context();
				System.out.println("修改事件启动... 目录地址："+currentPath+"/"+obj);
				
				//如果改文件是txt格式的话会读取改文件的内容
				if (obj.toString().endsWith(".txt")) {
					System.out.println("---------------------------------");
					String fileeee = currentPath.toString()+"/"+obj;

					FileReader fileReader = new FileReader(fileeee);
					String result = fileReader.readString();
					System.out.println(obj.toString()+"文件修改后内容为："+result);
					System.out.println("---------------------------------");
				}
				
			}
			
			public void onDelete(WatchEvent<?> event, Path currentPath) {
				Object obj = event.context();
				System.out.println("删除事件启动... 目录地址："+currentPath+obj);
				
			}
			
			public void onCreate(WatchEvent<?> event, Path currentPath) {
				Object obj = event.context();
				System.out.println("创建事件启动... 目录地址："+currentPath+obj);
				
			}
		});
		
		//设置监听目录的最大深入，目录层级大于制定层级的变更将不被监听，默认只监听当前层级目录
		watchMonitor.setMaxDepth(3);
		//启动监听
		watchMonitor.start();
		
		
		
		/**
		 * 监听全部事件
		 */
//		WatchMonitor.createAll(file, new SimpleWatcher(){
//			@Override
//			public void onModify(WatchEvent<?> event, Path currentPath) {
//				System.out.println("EVENT modify...");
//			}
//		}).start();
		
		/**
		 * 延迟处理监听事件
		 */
		
//		WatchMonitor monitor = WatchMonitor.createAll("d:/", new DelayWatcher(watch, 500));
//		monitor.start();

	}
}
