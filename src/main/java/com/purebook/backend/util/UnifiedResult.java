package com.purebook.backend.util;

import com.purebook.backend.result.JsonResult;
import com.purebook.backend.result.JsonResultwithData;
import com.purebook.backend.result.ResultCode;

import java.util.List;

public class UnifiedResult {
    public static <E> JsonResult result(List<E> list, ResultCode code) {
        if (list.size() != 0) {
            JsonResultwithData jsonResultwithData = new JsonResultwithData();
            jsonResultwithData.setData(list);
            return jsonResultwithData;
        }
        return new JsonResult(code);
    }

    public static <E> JsonResult result(E element, ResultCode code) {
        if (element != null) {
            JsonResultwithData jsonResultwithData = new JsonResultwithData();
            jsonResultwithData.setData(element);
            return jsonResultwithData;
        }
        return new JsonResult(code);
    }

    public static JsonResult result(ResultCode code, boolean element) {
        if (element) {
            return new JsonResult(ResultCode.SUCCESS);
        }
        return new JsonResult(code);
    }
}
