package com.cool.advice;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * 日志文件一天为单位 每天会产生不同的日志
 * aop schema方式 增强类 主要用来记录项目出错的记录
 * 这是一个记录错误日志的代理
 * 完整版日志请查看sky-log.html文件
 * 错误日志请查看sky-exection.log文件
 * @author JINGE
 */
/**
 * @Auther: cjc 2018/9/1 0001
 */
public class MyAdviceLogger {
	private Logger log =Logger.getLogger("Exception"); //定义异常的日志对象 日志调请查看Exception.log

	//异常增强类
	public void afterThrowing(JoinPoint p,Exception e) throws Throwable{
		String str="执行【"+p.getTarget()+"】类的【"+p.getSignature()+"】方法出错,方法参数是【"+Arrays.toString(p.getArgs())+
				"】,异常信息是【"+e+"】";
		log.error(str);
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw, true));
		System.out.println("i520java框架错误输出显示[不会终止程序]---->"+sw.toString());

	}

	//环绕增强（这里使用来处理 报错后程序正常运行  并将错误信息保存为sky-exception.log）
	@SuppressWarnings("rawtypes")
	public  Object  aroundLogger(ProceedingJoinPoint jp){
		Object  object=null;
		Class returnType=null;
		System.err.println( jp.getSignature());
		try {
			Signature signature =  jp.getSignature();
			returnType = ((MethodSignature) signature).getReturnType();
			object= jp.proceed();
			if(returnType.toString().contains("boolean") ||returnType.toString().contains("Boolean")){
				if((Boolean)(object)==false){
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				}

			}
			return object;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			String strs="执行【"+jp.getTarget()+"】类的【"+jp.getSignature()+"】方法出错,方法参数是【"+Arrays.toString(jp.getArgs())+
					"】,异常信息是【"+e+"】";

			log.error(strs);
			//此处出入异常不会影响程序的运行 不想在控制台出入注释掉即可
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			String str = sw.toString();
			System.err.println("错误输出显示[不会终止程序]---->"+str);
			if(returnType.toString().contains("List") ){
				return  new ArrayList<Object>();
			}else if(returnType.toString().contains("boolean") ||returnType.toString().contains("Boolean") ){
				return  false;
			}else if(returnType.toString().contains("Integer") ||returnType.toString().contains("int")||returnType.toString().contains("Dcouble")||
					returnType.toString().contains("double") ||returnType.toString().contains("Float")||returnType.toString().contains("float") ||
					returnType.toString().contains("Long")||returnType.toString().contains("long")   ){
				return  0;
			}else if(returnType.toString().contains("String") ){
				return  "error";
			}else if(returnType.toString().contains("Map") ){
				return new HashMap<String, Object>();
			}else{
				return null;
			}

		} catch (Throwable e) {

			log.error("执行【"+jp.getTarget()+"】类的【"+jp.getSignature()+"】方法出错,方法参数是【"+Arrays.toString(jp.getArgs())+
					"】,异常信息是【"+e+"】");
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			String str = sw.toString();
			System.err.println("i520java框架错误输出显示[不会终止程序]---->"+str);

			if(returnType.toString().contains("List") ){
				return  new ArrayList<Object>();
			}else if(returnType.toString().contains("boolean") ||returnType.toString().contains("Boolean") ){
				return  false;
			}else if(returnType.toString().contains("Integer") ||returnType.toString().contains("int") ){
				return  0;
			}else{
				return null;
			}
		}
	}


}
