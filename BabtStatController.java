package com.babt.manager.stat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babt.base.util.HttpRequestHelper;
import com.babt.base.util.PropertiesHelper;
import com.babt.core.web.controller.BaseController;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



@Controller
@RequestMapping(value="/stat")
public class BabtStatController extends BaseController {


	private String getStatString(String statAction, String params) {
		PropertiesHelper propHelper = PropertiesHelper.getInstance("public_system.properties");
		String urlStr = propHelper.getString("statistic.service.url");
		String s = HttpRequestHelper.sendGet(urlStr + statAction, params);
		return s;
	}

	@RequestMapping(value = "/C_countByCarModel")
	@ResponseBody
	public Map<String, Object> C_countByCarModel() {
		String s = getStatString("/car/countByCarModel","");

		JSONArray jsonArray = JSONArray.fromObject(s);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<String> category = new ArrayList<String>();
		List<String> data = new ArrayList<String>();

		Object[] objs = jsonArray.toArray();
		for (Object object : objs) {
			JSONObject jsonObject = JSONObject.fromObject(object);
			String key = "";
			String value = "";

			if (jsonObject.has("modelName")) {
				key = jsonObject.getString("modelName");
				category.add(key);
			}
			if (jsonObject.has("count")) {
				value = jsonObject.getString("count");
				data.add(value);
			}
			
		}
		resultMap.put("category", category);
		resultMap.put("data", data);
		return resultMap;
	}
	

	@RequestMapping(value = "/C_countByMonth")
	@ResponseBody
	public Map<String, Object> C_countByMonth() {
		String s = getStatString("/car/countByMonth","");

		JSONArray jsonArray = JSONArray.fromObject(s);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<String> category = new ArrayList<String>();
		List<String> data = new ArrayList<String>();

		Object[] objs = jsonArray.toArray();
		for (Object object : objs) {
			JSONObject jsonObject = JSONObject.fromObject(object);
			String key = "";
			String value = "";

			if (jsonObject.has("month")) {
				key = jsonObject.getString("month");
				category.add(key);
			}
			if (jsonObject.has("count")) {
				value = jsonObject.getString("count");
				data.add(value);
			}
			
		}
		resultMap.put("category", category);
		resultMap.put("data", data);
		return resultMap;
	}
	

	@RequestMapping(value = "/B_dataRatio")
	@ResponseBody
	public Object B_dataRatio() {
		String s = getStatString("/battery/dataRatio","");
		return s;
	}

	@RequestMapping(value = "/B_avgSurplus")
	@ResponseBody
	public Object B_avgSurplus() {
		String s = getStatString("/battery/avgSurplus","");
		return s;
	}

	@RequestMapping(value = "/C_countEvalCar")
	@ResponseBody
	public Object C_countEvalCar() {
		// TODO 统计的不正确时间和数量二维表
		String s = getStatString("/car/countEvalCar","");
		// TODO处理 数据结构
		return s;
	}

	@RequestMapping(value = "/C_evalTimeConsumeByWeek")
	@ResponseBody
	public Map<String, Object> C_evalTimeConsumeByWeek() {
		String s = getStatString("/car/evalTimeConsumeByWeek","");

		JSONArray jsonArray = JSONArray.fromObject(s);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<String> category = new ArrayList<String>();
		List<String> data = new ArrayList<String>();

		Object[] objs = jsonArray.toArray();
		for (Object object : objs) {
			JSONObject jsonObject = JSONObject.fromObject(object);
			String key = "";
			String value = "";

			if (jsonObject.has("mondayOp")) {
				key = jsonObject.getString("mondayOp");
				category.add(key);
			}
			if (jsonObject.has("avgTimeConsumer")) {
				value = jsonObject.getString("avgTimeConsumer");
				data.add(value);
			}
			
		}
		resultMap.put("category", category);
		resultMap.put("data", data);
		return resultMap;
	}

	@RequestMapping(value = "/C_countCity")
	@ResponseBody
	public Object C_countCity() {
		String s = getStatString("/car/countCity","");
		return s;
	}

	@RequestMapping(value = "/C_countCarModel")
	@ResponseBody
	public Object C_countCarModel() {
		String s = getStatString("/car/countCarModel","");
		return s;
	}

	@RequestMapping(value = "/C_countCarManufacture")
	@ResponseBody
	public Object C_countCarManufacture() {
		String s = getStatString("/car/countCarManufacture","");
		return s;
	}

	@RequestMapping(value = "/B_evalBatteryCount")
	@ResponseBody
	public Object B_evalBatteryCount() {
		String s = getStatString("/battery/evalBatteryCount","");
		return s;
	}

	@RequestMapping(value = "/B_countModel")
	@ResponseBody
	public Object B_countModel() {
		String s = getStatString("/battery/countModel","");
		return s;
	}

	@RequestMapping(value = "/B_countManufacturer")
	@ResponseBody
	public Object B_countManufacturer() {
		String s = getStatString("/battery/countManufacturer","");
		return s;
	}

	// 评估电池总数量（月） 时间分布
	@RequestMapping(value = "/B_capAndSup")
	@ResponseBody
	public Object B_capAndSup() {
		String s = getStatString("/battery/capAndSup","");
		JSONObject jsonObject = JSONObject.fromObject(s);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String sumCapcity ="";
		String sumSurplus =  "";
		if (jsonObject.has("sumCapcity")) {
			 sumCapcity = jsonObject.getString("sumCapcity");
			 resultMap.put("sumCapcity", sumCapcity);
		}
		if (jsonObject.has("sumSurplus")) {
			sumSurplus = jsonObject.getString("sumSurplus");
			resultMap.put("sumSurplus", sumSurplus);
		}
		
		

		return resultMap;
	}

	@RequestMapping(value = "/C_evlTimeConsume")
	@ResponseBody
	public Object C_evlTimeConsume() {
		String s = getStatString("/car/evlTimeConsume","");
		
		JSONArray jsonArray = JSONArray.fromObject(s);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<String> category = new ArrayList<String>();
		List<Object> data = new ArrayList<Object>();

		Object[] objs = jsonArray.toArray();
		for (Object object : objs) {
			JSONObject jsonObject = JSONObject.fromObject(object);
			String key = "";
			Object value ;

			if (jsonObject.has("week")) {
				key = jsonObject.getString("week");
				category.add(key);
			}
			if (jsonObject.has("minutes")) {
				value = jsonObject.getInt("minutes");
				data.add(value);
			}
			
		}
		
		resultMap.put("category", category);
		resultMap.put("data", data);

		return resultMap;
	}
	
	@RequestMapping(value = "/B_countByMonth")
	@ResponseBody
	public Map<String, Object> B_countByMonth() {
		String s = getStatString("/battery/countByMonth","");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> category = new ArrayList<Object>();
		List<Object> data = new ArrayList<Object>();
		JSONObject jo = JSONObject.fromObject(s);
	    Iterator jsnIt = jo.keys();
	    while(jsnIt.hasNext())
	    {
	    	   Object ko = jsnIt.next();
	    	   Object value = jo.get(ko);
	    	   category.add(ko);
	    	   data.add(value);
	    }
	    
	    resultMap.put("category", category);
		resultMap.put("data", data);

		

		return resultMap;
	}
	
	@RequestMapping(value = "/B_avgBatteryCapByAge")
	@ResponseBody
	public Map<String, Object> B_avgBatteryCapByAge() {
		String s = getStatString("/battery/avgBatteryCapByAge","");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> category = new ArrayList<Object>();
		List<Object> data = new ArrayList<Object>();
		JSONObject jo = JSONObject.fromObject(s);
	    Iterator jsnIt = jo.keys();
	    while(jsnIt.hasNext())
	    {
	    	   Object ko = jsnIt.next();
	    	   JSONObject value = jo.get(ko) !=null ? JSONObject.fromObject(jo.get(ko)) : null;
	    	   if(value!=null && value.has("avgSurplusCap"))
	    	   {
		    		   category.add(ko);
		    		   data.add(value.getString("avgSurplusCap"));
	    	   }
	    	   
	    }
	    
	    resultMap.put("category", category);
		resultMap.put("data", data);

		

		return resultMap;
	}
	@RequestMapping(value = "/B_countCarOfEvalBatteryByModel")
	@ResponseBody
	public Map<String, Object> B_countCarOfEvalBatteryByModel() {
		String s = getStatString("/battery/countCarOfEvalBatteryByModel","");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> category = new ArrayList<Object>();
		List<Object> data = new ArrayList<Object>();
		JSONObject jo = JSONObject.fromObject(s);
	    Iterator jsnIt = jo.keys();
	    while(jsnIt.hasNext())
	    {
	    	   Object ko = jsnIt.next();
	    	   Object value = jo.get(ko);
	    	   category.add(ko);
	    	   data.add(value);
	    }
	    
	    resultMap.put("category", category);
		resultMap.put("data", data);
		return resultMap;
	}
	
	@RequestMapping(value = "/B_fiveYearAgeSurplus")
	@ResponseBody
	public Map<String, Object> B_fiveYearAgeSurplus() {
		String s = getStatString("/battery/fiveYearAgeSurplus","");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Object> category = new ArrayList<Object>();
		List<Object> data = new ArrayList<Object>();
		JSONObject jo = JSONObject.fromObject(s);
	    Iterator jsnIt = jo.keys();
	    while(jsnIt.hasNext())
	    {
	    	   Object ko = jsnIt.next();
	    	   JSONObject value = jo.get(ko) !=null ? JSONObject.fromObject(jo.get(ko)) : null;
	    	   if(value!=null && value.has("avgSurplus"))
	    	   {
		    		   category.add(ko);
		    		   data.add(value.getString("avgSurplus"));
	    	   }
	    	   
	    }
	    
	    resultMap.put("category", category);
		resultMap.put("data", data);
		return resultMap;
	}
	@RequestMapping(value = "/C_goeStat")
	@ResponseBody
	public Object C_goeStat(String code, Integer codeType,Integer n, Integer intervalType ) {
		//String s = getStatString("/car/data4map?carModelId="+carModelId+"&bPManufacturer="+bPManufacturer+"&area="+area+"&startTime="+"&startTime="+endTime);
		
		//String s = getStatString("/car/goeStat?code="+code+"&codeType="+codeType+"&n="+n+"&intervalType="+intervalType);
		/*
		{
		  "2018-06-11":{"福建省":[],"西藏自治区":[],"贵州省":[]}，
		  "2018-06-12":{"福建省":[],"西藏自治区":[],"贵州省":[]}
		  }
		
		*/
		String s = getStatString("/car/goeStat","codeType=0&n=12&intervalType=0");	
		JSONObject goesObject = JSONObject.fromObject(s);
		//JSONArray goesArray = JSONArray.fromObject(goesObject);
		Iterator goesDateIt = goesObject.keys();
		
		Map<String, Object> goesResultMap = new HashMap<String, Object>();
		ArrayList<Object> resultData = null;
		Integer maxValue = 0;  //记录最大值
		 while(goesDateIt.hasNext())
		 {
		   Object dateDatasKey = goesDateIt.next();
	    	   JSONObject datas = goesObject.get(dateDatasKey) !=null ? JSONObject.fromObject(goesObject.get(dateDatasKey)) : null;
	    	   Iterator goesAreaIt = datas.keys();
	    	   
	    	   while(goesAreaIt.hasNext())
	    	   {
	    		   String areaKey = (String)goesAreaIt.next();
	    		   Object areaData = datas.get(areaKey);
	    		   JSONArray areaDataArray = JSONArray.fromObject(areaData);
	    		   int dataSize = areaDataArray.size(); 
	    		   Map<String, Object> valueMap = null; 
	    		   if(dataSize>0 && !areaDataArray.getJSONObject(0).isNullObject())
	    		   {
	    			   JSONObject valueObject = areaDataArray.getJSONObject(0);
	    			   valueMap = new HashMap<String, Object>();
	    			   Iterator valueIt = valueObject.keys();
	    			   while(valueIt.hasNext())
	    			   {
	    				   String valueKey = (String)valueIt.next();
	    	    		   	   Object value = valueObject.get(valueKey);
	    	    		   	   	if(valueKey.equals("carCount") )
	    	    		   	   	{
	    	    		   	   		valueMap.put("value", Integer.valueOf(value.toString()));
	    	    		   	   	}
		    	    		   	if(valueKey.equals("longitude") )
		    	    		   	{
		    	    		   		valueMap.put("positionH",Float.valueOf(value.toString()));
		    	    		   	}
		    	    		   	if(valueKey.equals("latitude") ) 
		    	    		   	{
		    	    		   		valueMap.put("positionV", Float.valueOf(value.toString()));
		    	    		   	}
	    			   }
	    			   
	    		   }
	    		  if(valueMap!=null )
			   {
	    			  
	   			  
	    			  if (goesResultMap.containsKey(areaKey) &&  goesResultMap.get(areaKey)!=null)
					{
	    				    HashMap<String, Object> areaMap = (HashMap<String, Object>) goesResultMap.get(areaKey);
	    				    Integer carCountValue = (Integer)areaMap.get("value");
	    				    Integer otherCarCountValue = (Integer)valueMap.get("value");
						Integer newValue = carCountValue + otherCarCountValue;
						 if(maxValue < newValue)
			   			   {
			   				   maxValue = newValue;
			   			   }
						
						areaMap.put(areaKey, newValue);
						goesResultMap.put(areaKey, areaMap);
						
					}
					else 
					{
						goesResultMap.put(areaKey, valueMap);
						Integer newValue = (Integer)valueMap.get("value");
						if(maxValue < newValue)
			   			   {
			   				   maxValue = newValue;
			   			   }
					}
				}
	    		   
	    	   }
		
		 }
		 
  	   
  	   
		 if(goesResultMap!=null && !goesResultMap.isEmpty() )
		 {
			   resultData = new ArrayList< Object>();
			   Iterator resultIt = goesResultMap.keySet().iterator();
			   
			   while (resultIt.hasNext())
			   {
				   String goeKey = (String)resultIt.next();
				   Map<String, Object> tempGeoeMap = (Map<String, Object>)goesResultMap.get(goeKey);
				   Map<String, Object> tempDataMap = new HashMap<String, Object>();
				   ArrayList<Object> tempDataValue = new ArrayList<Object>();
				   tempDataValue.add(tempGeoeMap.get("positionH"));
				   tempDataValue.add(tempGeoeMap.get("positionV"));
				   tempDataValue.add(tempGeoeMap.get("value"));
				  
				   
				   tempDataMap.put("name", goeKey);
				   tempDataMap.put("value",tempDataValue);
				   tempDataMap.put("max",maxValue);
				   resultData.add(tempDataMap);
			   }
		   }
  	   
		 return resultData;
	}


@RequestMapping(value = "/C_carmap_goeStat")
@ResponseBody
public Object C_carmap_goeStat(String code, Integer codeType,Integer n, Integer intervalType ) {
	//String s = getStatString("/car/data4map?carModelId="+carModelId+"&bPManufacturer="+bPManufacturer+"&area="+area+"&startTime="+"&startTime="+endTime);
	
	//String s = getStatString("/car/goeStat?code="+code+"&codeType="+codeType+"&n="+n+"&intervalType="+intervalType);
	/*
	{
	  "2018-06-11":{"福建省":[],"西藏自治区":[],"贵州省":[]}，
	  "2018-06-12":{"福建省":[],"西藏自治区":[],"贵州省":[]}
	  }
	
	*/
	String s = getStatString("/car/goeStat","codeType=0&n=12&intervalType=0");	
	JSONObject goesObject = JSONObject.fromObject(s);
	//JSONArray goesArray = JSONArray.fromObject(goesObject);
	Iterator goesDateIt = goesObject.keys();
	
	Map<String, Object> goesResultMap = new HashMap<String, Object>();
	ArrayList<Object> resultData = null;
    
	 while(goesDateIt.hasNext())
	 {
	   Object dateDatasKey = goesDateIt.next();
    	   JSONObject datas = goesObject.get(dateDatasKey) !=null ? JSONObject.fromObject(goesObject.get(dateDatasKey)) : null;
    	   Iterator goesAreaIt = datas.keys();
    	   
    	   while(goesAreaIt.hasNext())
    	   {
    		   String areaKey = (String)goesAreaIt.next();
    		   Object areaData = datas.get(areaKey);
    		   JSONArray areaDataArray = JSONArray.fromObject(areaData);
    		   int dataSize = areaDataArray.size(); 
    		   Map<String, Object> valueMap = null; 
    		   if(dataSize>0 && !areaDataArray.getJSONObject(0).isNullObject())
    		   {
    			   JSONObject valueObject = areaDataArray.getJSONObject(0);
    			   valueMap = new HashMap<String, Object>();
    			   Iterator valueIt = valueObject.keys();
    			   while(valueIt.hasNext())
    			   {
    				   String valueKey = (String)valueIt.next();
    	    		   	   Object value = valueObject.get(valueKey);
	    	    		   	if(valueKey.equals("latitude") ) 
	    	    		   	{
	    	    		   		valueMap.put("positionH", Float.valueOf(value.toString()));
	    	    		   	}
	    	    		   	if(valueKey.equals("longitude") )
	    	    		   	{
	    	    		   		valueMap.put("positionV",Float.valueOf(value.toString()));
	    	    		   	}
	    	    		   	if(valueKey.equals("carCount") )
    	    		   	   	{
    	    		   	   		valueMap.put("value", Integer.valueOf(value.toString()));
    	    		   	   	}
    			   }
    			   
    		   }
    		  if(valueMap!=null )
		   {
    			 
    			  	
    			  if (goesResultMap.containsKey(areaKey) &&  goesResultMap.get(areaKey)!=null)
				{
    				    HashMap<String, Object> areaMap = (HashMap<String, Object>) goesResultMap.get(areaKey);
    				    Integer carCountValue = (Integer)areaMap.get("value");
    				    Integer otherCarCountValue = (Integer)valueMap.get("value");
					Integer newValue = carCountValue + otherCarCountValue;
					areaMap.put(areaKey, newValue);
					goesResultMap.put(areaKey, areaMap);
					
					
				}
				else 
				{
					goesResultMap.put(areaKey, valueMap);
				}
			}
    		   
    	   }
    	   //JSONArray areaDataArray = new JSONArray();
    	   

	
	
	
	 }
	 
	   if(goesResultMap!=null && !goesResultMap.isEmpty() )
	   {
		   resultData = new ArrayList< Object>();
		   Iterator resultIt = goesResultMap.keySet().iterator();
		   int i=0;
		   while (resultIt.hasNext())
		   {
			   String goeKey = (String)resultIt.next();
			   resultData.add((Map<String, Object>)goesResultMap.get(goeKey));
		   }
	   }
	   
	 return resultData;
	}
     @RequestMapping(value = "/C_totalBatteryEvlCount")
     @ResponseBody
      public Object B_totalBatteryEvlCount() {
	      String s = getStatString("/batterystat/totalBatteryEvlCount","");
       	  return s;
     }
    @RequestMapping(value = "/C_totalEvlCount")
    @ResponseBody
      public Object B_totalEvlCount() {
	   String s = getStatString("/batterystat/totalEvlCount","");
	   return s;
    }
    @RequestMapping(value = "/C_totalBatteryEvlCapacityCount")
    @ResponseBody
      public Object B_totalBatteryEvlCapacityCount() {
	     String s = getStatString("/batterystat/totalBatteryEvlCapacityCount","");
	    return s;
      }
    @RequestMapping(value = "/C_batteryTotalEvlCount")
    @ResponseBody
      public Object B_batteryTotalEvlCount() {
	     String s = getStatString("/batterystat/batteryTotalEvlCount","");
	    return s;
      }
    @RequestMapping(value = "/C_carTotalEvlCount")
    @ResponseBody
      public Object B_carTotalEvlCount() {
	     String s = getStatString("/batterystat/carTotalEvlCount","");
	    return s;
      }
    @RequestMapping(value = "/C_batteryEvlCarCount")
    @ResponseBody
      public Object B_batteryEvlCarCount() {
	     String s = getStatString("/batterystat/batteryEvlCarCount","");
	    return s;
      }
    @RequestMapping(value = "/C_batteryEvlBatteryCount")
    @ResponseBody
      public Object B_batteryEvlBatteryCount() {
	     String s = getStatString("/batterystat/batteryEvlBatteryCount","");
	    return s;
      }
    @RequestMapping(value = "/C_batteryEvlCountLastYear")
    @ResponseBody
      public Object B_batteryEvlCountLastYear() {
	     String s = getStatString("/batterystat/batteryEvlCountLastYear","");
	     JSONObject jsonObject = JSONObject.fromObject(s);
			Map<Integer,Object> resultMap=new HashMap<Integer,Object>();
			for(int i=1;i<=12;i++) {
				if(jsonObject.has(""+i)) resultMap.put(i,jsonObject.getString(""+i));
			}
		return resultMap;
      }
    @RequestMapping(value = "/C_batteryEvlBatteryCountLastYear")
    @ResponseBody
      public Object B_batteryEvlBatteryCountLastYear() {
	     String s = getStatString("/batterystat/batteryEvlBatteryCountLastYear","");
	     JSONObject jsonObject = JSONObject.fromObject(s);
			Map<Integer,Object> resultMap=new HashMap<Integer,Object>();
			for(int i=1;i<=12;i++) {
				if(jsonObject.has(""+i)) resultMap.put(i,jsonObject.getString(""+i));
			}
		return resultMap;
      }
    
    @RequestMapping(value = "/C_evlAvgSoc")
    @ResponseBody
      public Object B_evlAvgSoc() {
	     String s = getStatString("/batterystat/evlAvgSoc","");
	    return s;
      }
    @RequestMapping(value = "/C_evlAvgSoc90")
    @ResponseBody
      public Object B_evlAvgSoc90() {
	     String s = getStatString("/batterystat/evlAvgSoc90","");
	    return s;
      }
    @RequestMapping(value = "/C_evlAvgSoc80")
    @ResponseBody
      public Object B_evlAvgSoc80() {
	     String s = getStatString("/batterystat/evlAvgSoc80","");
	    return s;
      }
    @RequestMapping(value = "/C_evlAvgSoc70")
    @ResponseBody
      public Object B_evlAvgSoc70() {
	     String s = getStatString("/batterystat/evlAvgSoc70","");
	    return s;
      }
    @RequestMapping(value = "/C_evlAvgSoc60")
    @ResponseBody
      public Object B_evlAvgSoc60() {
	     String s = getStatString("/batterystat/evlAvgSoc60","");
	    return s;
      }
    @RequestMapping(value = "/C_evlAvgSoc0")
    @ResponseBody
      public Object B_evlAvgSoc0() {
	     String s = getStatString("/batterystat/evlAvgSoc0","");
	    return s;
      }
    @RequestMapping(value = "/C_carBatteryEvlCount")
    @ResponseBody
      public Object B_carBatteryEvlCount() {
	     String s = getStatString("/batterystat/carBatteryEvlCount","");
	    return s;
      }
    @RequestMapping(value = "/C_carBatteryEvlCarCount")
    @ResponseBody
      public Object B_carBatteryEvlCarCount() {
	     String s = getStatString("/batterystat/carBatteryEvlCarCount","");
	    return s;
      }
    @RequestMapping(value = "/C_carBatteryEvlCarModelCount")
    @ResponseBody
      public Object B_carBatteryEvlCarModelCount() {
	     String s = getStatString("/batterystat/carBatteryEvlCarModelCount","");
	    return s;
      }
    @RequestMapping(value = "/C_dBatteryEvlCount")
    @ResponseBody
      public Object B_dBatteryEvlCount() {
	     String s = getStatString("/batterystat/dBatteryEvlCount","");
	    return s;
      }
    @RequestMapping(value = "/C_dBatteryEvlBatteryCount")
    @ResponseBody
      public Object B_dBatteryEvlBatteryCount() {
	     String s = getStatString("/batterystat/dBatteryEvlBatteryCount","");
	    return s;
      }
    @RequestMapping(value = "/C_dBatteryEvlBatteryModelCount")
    @ResponseBody
      public Object B_dBatteryEvlBatteryModelCount() {
	     String s = getStatString("/batterystat/dBatteryEvlBatteryModelCount","");
	    return s;
      }
    
    @RequestMapping(value = "/C_carBatteryEvlCountLastYear")
    @ResponseBody
      public Object B_carBatteryEvlCountLastYear() {
	     String s = getStatString("/batterystat/carBatteryEvlCountLastYear","");
	     JSONObject jsonObject = JSONObject.fromObject(s);
			Map<Integer,Object> resultMap=new HashMap<Integer,Object>();
			for(int i=1;i<=12;i++) {
				if(jsonObject.has(""+i)) resultMap.put(i,jsonObject.getString(""+i));
			}
		return resultMap;
      }
    @RequestMapping(value = "/C_carBatteryEvlCarCountLastYear")
    @ResponseBody
      public Object B_carBatteryEvlCarCountLastYear() {
	     String s = getStatString("/batterystat/carBatteryEvlCarCountLastYear","");
	     JSONObject jsonObject = JSONObject.fromObject(s);
			Map<Integer,Object> resultMap=new HashMap<Integer,Object>();
			for(int i=1;i<=12;i++) {
				if(jsonObject.has(""+i)) resultMap.put(i,jsonObject.getString(""+i));
			}
		return resultMap;
      }
    @RequestMapping(value = "/C_dBatteryEvlCountLastYear")
    @ResponseBody
      public Object B_dBatteryEvlCountLastYear() {
	     String s = getStatString("/batterystat/dBatteryEvlCountLastYear","");
	     JSONObject jsonObject = JSONObject.fromObject(s);
			Map<Integer,Object> resultMap=new HashMap<Integer,Object>();
			for(int i=1;i<=12;i++) {
				if(jsonObject.has(""+i)) resultMap.put(i,jsonObject.getString(""+i));
			}
		return resultMap;
      }
    @RequestMapping(value = "/C_dBatteryEvlBatteryCountLastYear")
    @ResponseBody
      public Object B_dBatteryEvlBatteryCountLastYear() {
	     String s = getStatString("/batterystat/dBatteryEvlBatteryCountLastYear","");
	     JSONObject jsonObject = JSONObject.fromObject(s);
			Map<Integer,Object> resultMap=new HashMap<Integer,Object>();
			for(int i=1;i<=12;i++) {
				if(jsonObject.has(""+i)) resultMap.put(i,jsonObject.getString(""+i));
			}
		return resultMap;
      }

}

	

	
	
	
	
	
	
	
	

