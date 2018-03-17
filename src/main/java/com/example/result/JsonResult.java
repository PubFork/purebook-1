package com.example.result;

public class JsonResult {

	protected String code;  
    protected String message;  
      
    public JsonResult() {  
        this.setCode(ResultCode.SUCCESS);  
        this.setMessage("成功！");  
          
    }  
      
    public JsonResult(ResultCode code) {  
        this.setCode(code);  
        this.setMessage(code.msg());  
    }  
      
    public JsonResult(ResultCode code, String message) {  
        this.setCode(code);  
        this.setMessage(message);  
    }  
       
    public String getCode() {  
        return code;  
    }  
    public void setCode(ResultCode code) {  
        this.code = code.val();  
    }  
    public String getMessage() {  
        return message;  
    }  
    public void setMessage(String message) {  
        this.message = message;  
    }  
}
