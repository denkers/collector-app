package com.kyleruss.collector.mobile.record;

import org.json.JSONObject;

public interface RecordTranslator<T extends RecordTranslator>
{
    public T mapToRecord(JSONObject obj);

    public JSONObject serializeRecord();
}
