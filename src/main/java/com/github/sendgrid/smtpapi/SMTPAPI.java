package com.github.sendgrid.smtpapi;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.Map;

public class SMTPAPI {

  private JSONObject header = new JSONObject();

  public SMTPAPI()  {

  }

  public SMTPAPI(JSONObject header) {
    this.header = header;
  }

  public SMTPAPI addTo(String to) throws JSONException {
    this.header.append("to", to);
    return this;
  }

  public SMTPAPI addTo(String[] to) throws JSONException {
    for(int i = 0; i < to.length; i ++) {
      addTo(to[i]);
    }
    return this;
  }

  public SMTPAPI setTos(String[] to) throws JSONException {
    this.header.put("to", to);
    return this;
  }

  public JSONArray getTos() throws JSONException {
    return this.header.getJSONArray("to");
  }

  public SMTPAPI addSubstitution(String key, String val) throws JSONException {
    if (this.header.isNull("sub")) {
      this.header.put("sub", new JSONObject());
    }
    this.header.getJSONObject("sub").append(key, val);
    return this;
  }

  public SMTPAPI addSubstitution(String key, String[] val) throws JSONException {
    for (int i = 0; i < val.length; i++) {
      addSubstitution(key, val[i]);
    }
    return this;
  }

  public SMTPAPI setSubstitutions(JSONObject subs) throws JSONException {
    this.header.put("sub", subs);
    return this;
  }

  public JSONObject getSubstitutions() throws JSONException {
    return this.header.getJSONObject("sub");
  }

  public SMTPAPI addUniqueArg(String key, String val) throws JSONException {
    if (this.header.isNull("unique_args")) {
      this.header.put("unique_args", new JSONObject());
    }
    this.header.getJSONObject("unique_args").put(key, val);
    return this;
  }

  public SMTPAPI setUniqueArgs(Map<String, String> args) throws JSONException {
    this.header.put("unique_args", args);
    return this;
  }

  public SMTPAPI setUniqueArgs(JSONObject args) throws JSONException {
    this.header.put("unique_args", args);
    return this;
  }

  public JSONObject getUniqueArgs() throws JSONException {
    return this.header.getJSONObject("unique_args");
  }

  public SMTPAPI addCategory(String val) throws JSONException {
    this.header.append("category", val);
    return this;
  }

  public SMTPAPI addCategory(String[] vals) throws JSONException {
    for (int i = 0; i < vals.length; i++) {
      addCategory(vals[i]);
    }
    return this;
  }

  public SMTPAPI setCategories(String[] cat) throws JSONException {
    this.header.put("category", cat);
    return this;
  }

  public JSONArray getCategories() throws JSONException {
    return this.header.getJSONArray("category");
  }

  public SMTPAPI addSection(String key, String val) throws JSONException {
    if (this.header.isNull("section")) {
      this.header.put("section", new JSONObject());
    }
    this.header.getJSONObject("section").put(key, val);
    return this;
  }

  public SMTPAPI setSections(JSONObject sec) throws JSONException {
    this.header.put("section", sec);
    return this;
  }

  public JSONObject getSections() throws JSONException {
    return this.header.getJSONObject("section");
  }

  public SMTPAPI addFilter(String filter, String setting, String val) throws JSONException {
    if (this.header.isNull("filters")) {
      this.header.put("filters", new JSONObject());
    }
    if (this.header.getJSONObject("filters").isNull(filter)) {
      this.header.getJSONObject("filters").put(filter, new JSONObject());
      this.header.getJSONObject("filters").getJSONObject(filter).put("settings", new JSONObject());
    }
    this.header.getJSONObject("filters").getJSONObject(filter).getJSONObject("settings").put(setting, val);
    return this;
  }

  public SMTPAPI addFilter(String filter, String setting, int val) throws JSONException {
    if (this.header.isNull("filters")) {
      this.header.put("filters", new JSONObject());
    }
    if (this.header.getJSONObject("filters").isNull(filter)) {
      this.header.getJSONObject("filters").put(filter, new JSONObject());
      this.header.getJSONObject("filters").getJSONObject(filter).put("settings", new JSONObject());
    }
    this.header.getJSONObject("filters").getJSONObject(filter).getJSONObject("settings").put(setting, val);
    return this;
  }

  public SMTPAPI setFilters(JSONObject filters) throws JSONException {
    this.header.put("filters", filters);
    return this;
  }

  public JSONObject getFilters() throws JSONException {
    return this.header.getJSONObject("filters");
  }

  public String jsonString() {
    return this.header.toString();
  }
}
