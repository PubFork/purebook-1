package com.example.result;

public class JsonResultwithData extends JsonResult{

    private Object data;  
      
    public JsonResultwithData() {  
        this.setCode(ResultCode.SUCCESS);  
        this.setMessage("成功！");  
    }  
      
    public JsonResultwithData(ResultCode code) {  
        this.setCode(code);  
        this.setMessage(code.msg());  
    }  
      
    public JsonResultwithData(ResultCode code, String message) {  
        this.setCode(code);  
        this.setMessage(message);  
    }  
      
    public JsonResultwithData(ResultCode code, String message, Object data) {  
        this.setCode(code);  
        this.setMessage(message);  
        this.setData(data);  
    }  
  
    public Object getData() {  
        return data;  
    }  
  
    public void setData(Object data) {  
        this.data = data;  
    }  
}
