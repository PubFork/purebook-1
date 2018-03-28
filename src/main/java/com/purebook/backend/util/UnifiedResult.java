package com.purebook.backend.util;

import com.example.result.JsonResult;
import com.example.result.JsonResultwithData;
import com.example.result.ResultCode;

import java.util.List;

public class UnifiedResult {
    public <E> JsonResult unifiedResult(List<E> list, ResultCode code) {
        if (list.size() != 0) {
            JsonResultwithData jsonResultwithData = new JsonResultwithData();
            jsonResultwithData.setData(list);
            return jsonResultwithData;
        }
        return new JsonResult(code);
    }

    public <E> JsonResult unifiedResult(E element, ResultCode code) {
        if (element != null) {
            JsonResultwithData jsonResultwithData = new JsonResultwithData();
            jsonResultwithData.setData(element);
            return jsonResultwithData;
        }
        return new JsonResult(code);
    }

    public JsonResult unifiedResult(ResultCode code, boolean element) {
        if (element) {
            return new JsonResult(ResultCode.SUCCESS);
        }
        return new JsonResult(code);
    }
}
