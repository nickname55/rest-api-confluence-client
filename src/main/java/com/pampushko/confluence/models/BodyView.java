package com.pampushko.confluence.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Getter
@Setter
@Slf4j
public class BodyView
{
	@SerializedName("value")
	String value;
	@SerializedName("representation")
	String representation;
	
	/*
        "view": {
          "value": "<p>.kjp</p>",
          "representation": "storage",
          "_expandable": {
            "webresource": "",
            "content": "/rest/api/content/88286276"
          }
	 */
}
