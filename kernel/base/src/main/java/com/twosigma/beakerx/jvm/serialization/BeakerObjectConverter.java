/*
 *  Copyright 2014 TWO SIGMA OPEN SOURCE, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.twosigma.beakerx.jvm.serialization;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface BeakerObjectConverter {
  public boolean isPrimitiveType(String tn);
  public boolean writeObject(Object obj, JsonGenerator jgen, boolean expand) throws IOException, JsonProcessingException;
  public String convertType(String tn);
  public Object deserialize(JsonNode n, ObjectMapper mapper);
  
  public void addTypeConversion(String from, String to);
  public void addTypeDeserializer(ObjectDeserializer o);
  public void addTypeSerializer(ObjectSerializer o);

  public void addfTypeDeserializer(ObjectDeserializer o);
  public void addfTypeSerializer(ObjectSerializer o);

  public void addThreadSpecificTypeConversion(String from, String to);
  public void addThreadSpecificTypeDeserializer(ObjectDeserializer o);
  public void addThreadSpecificTypeSerializer(ObjectSerializer o);
  
  public void addKnownBeakerType(String t);
  public boolean isKnownBeakerType(String t);
}
