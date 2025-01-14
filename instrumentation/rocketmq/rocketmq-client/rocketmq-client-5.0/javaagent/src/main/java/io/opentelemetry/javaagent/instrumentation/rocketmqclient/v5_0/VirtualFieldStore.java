/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.javaagent.instrumentation.rocketmqclient.v5_0;

import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.util.VirtualField;
import java.util.Map;
import org.apache.rocketmq.client.java.message.PublishingMessageImpl;

public class VirtualFieldStore {
  private static final VirtualField<PublishingMessageImpl, Context> messageContextField =
      VirtualField.find(PublishingMessageImpl.class, Context.class);
  private static final VirtualField<PublishingMessageImpl, Map<String, String>>
      messageExtraPropertiesField = VirtualField.find(PublishingMessageImpl.class, Map.class);

  private VirtualFieldStore() {}

  public static Context getContextByMessage(PublishingMessageImpl message) {
    return messageContextField.get(message);
  }

  public static void setContextByMessage(PublishingMessageImpl message, Context context) {
    messageContextField.set(message, context);
  }

  public static Map<String, String> getExtraPropertiesByMessage(PublishingMessageImpl message) {
    return messageExtraPropertiesField.get(message);
  }

  public static void setExtraPropertiesByMessage(
      PublishingMessageImpl message, Map<String, String> extraProperties) {
    messageExtraPropertiesField.set(message, extraProperties);
  }
}
