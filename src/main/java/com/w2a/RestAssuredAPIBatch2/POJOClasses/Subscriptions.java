package com.w2a.RestAssuredAPIBatch2.POJOClasses;

public class Subscriptions {
	 private String[] data;

	    private String has_more;

	    private String object;

	    private String total_count;

	    private String url;

	    public String[] getData ()
	    {
	        return data;
	    }

	    public void setData (String[] data)
	    {
	        this.data = data;
	    }

	    public String getHas_more ()
	    {
	        return has_more;
	    }

	    public void setHas_more (String has_more)
	    {
	        this.has_more = has_more;
	    }

	    public String getObject ()
	    {
	        return object;
	    }

	    public void setObject (String object)
	    {
	        this.object = object;
	    }

	    public String getTotal_count ()
	    {
	        return total_count;
	    }

	    public void setTotal_count (String total_count)
	    {
	        this.total_count = total_count;
	    }

	    public String getUrl ()
	    {
	        return url;
	    }

	    public void setUrl (String url)
	    {
	        this.url = url;
	    }

	   
}
