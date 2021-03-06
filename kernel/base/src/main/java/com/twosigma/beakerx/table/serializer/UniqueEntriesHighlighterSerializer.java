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
package com.twosigma.beakerx.table.serializer;

import com.twosigma.beakerx.util.SerializerUtil;
import com.twosigma.beakerx.table.highlight.UniqueEntriesHighlighter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class UniqueEntriesHighlighterSerializer extends JsonSerializer<UniqueEntriesHighlighter> {

  public static final String TYPE = "type";
  public static final String STYLE = "style";
  public static final String COL_NAME = "colName";

  @Override
  public void serialize(UniqueEntriesHighlighter value,
                        JsonGenerator jgen,
                        SerializerProvider provider)
    throws IOException, JsonProcessingException {

    synchronized (value) {
      jgen.writeStartObject();
      jgen.writeObjectField(TYPE, SerializerUtil.getTypeName(value));
      jgen.writeObjectField(COL_NAME, value.getColName());
      jgen.writeObjectField(STYLE, value.getStyle());
      jgen.writeEndObject();
    }
  }

}
