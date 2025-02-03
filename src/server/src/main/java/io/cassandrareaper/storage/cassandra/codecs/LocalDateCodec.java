/*
 * Copyright 2016-2017 Spotify AB
 * Copyright 2016-2018 The Last Pickle Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.cassandrareaper.storage.cassandra.codecs;

import java.nio.ByteBuffer;
import java.time.LocalDate;

import com.datastax.oss.driver.api.core.ProtocolVersion;
import com.datastax.oss.driver.api.core.type.DataType;
import com.datastax.oss.driver.api.core.type.codec.TypeCodec;
import com.datastax.oss.driver.api.core.type.reflect.GenericType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LocalDateCodec implements TypeCodec<LocalDate> {

  public LocalDateCodec() {}

  @Override
  public LocalDate parse(String value) {
    if (value == null || value.equals("NULL")) {
      return null;
    }
    return LocalDate.parse(value);
  }

  @NotNull
  @Override
  public GenericType<LocalDate> getJavaType() {
    return GenericType.LOCAL_DATE;
  }

  @NotNull
  @Override
  public DataType getCqlType() {
    return null;
  }

  @Nullable
  @Override
  public ByteBuffer encode(@Nullable LocalDate dateTime, @NotNull ProtocolVersion protocolVersion) {
    return null;
  }

  @Nullable
  @Override
  public LocalDate decode(@Nullable ByteBuffer byteBuffer, @NotNull ProtocolVersion protocolVersion) {
    return null;
  }

  @Override
  public String format(LocalDate value) {
    if (value == null) {
      return "NULL";
    }

    return value.toString();
  }
}
