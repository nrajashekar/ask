/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2013-04-29 14:08:19 UTC)
 * on 2013-05-04 at 07:41:24 UTC 
 * Modify at your own risk.
 */

package com.google.api.services.deviceinfoendpoint;

/**
 * Service definition for Deviceinfoendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link DeviceinfoendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Deviceinfoendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION == 14,
        "You are currently running with version %s of google-api-client. " +
        "You need version 1.14 of google-api-client to run version " +
        "1.14.2-beta of the  library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://55mylocation.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "deviceinfoendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Deviceinfoendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Deviceinfoendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getDeviceInfo".
   *
   * This request holds the parameters needed by the the deviceinfoendpoint server.  After setting any
   * optional parameters, call the {@link GetDeviceInfo#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public GetDeviceInfo getDeviceInfo(java.lang.String id) throws java.io.IOException {
    GetDeviceInfo result = new GetDeviceInfo(id);
    initialize(result);
    return result;
  }

  public class GetDeviceInfo extends DeviceinfoendpointRequest<com.google.api.services.deviceinfoendpoint.model.DeviceInfo> {

    private static final String REST_PATH = "deviceinfo/{id}";

    /**
     * Create a request for the method "getDeviceInfo".
     *
     * This request holds the parameters needed by the the deviceinfoendpoint server.  After setting
     * any optional parameters, call the {@link GetDeviceInfo#execute()} method to invoke the remote
     * operation. <p> {@link GetDeviceInfo#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetDeviceInfo(java.lang.String id) {
      super(Deviceinfoendpoint.this, "GET", REST_PATH, null, com.google.api.services.deviceinfoendpoint.model.DeviceInfo.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetDeviceInfo setAlt(java.lang.String alt) {
      return (GetDeviceInfo) super.setAlt(alt);
    }

    @Override
    public GetDeviceInfo setFields(java.lang.String fields) {
      return (GetDeviceInfo) super.setFields(fields);
    }

    @Override
    public GetDeviceInfo setKey(java.lang.String key) {
      return (GetDeviceInfo) super.setKey(key);
    }

    @Override
    public GetDeviceInfo setOauthToken(java.lang.String oauthToken) {
      return (GetDeviceInfo) super.setOauthToken(oauthToken);
    }

    @Override
    public GetDeviceInfo setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetDeviceInfo) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetDeviceInfo setQuotaUser(java.lang.String quotaUser) {
      return (GetDeviceInfo) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetDeviceInfo setUserIp(java.lang.String userIp) {
      return (GetDeviceInfo) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public GetDeviceInfo setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public GetDeviceInfo set(String parameterName, Object value) {
      return (GetDeviceInfo) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertDeviceInfo".
   *
   * This request holds the parameters needed by the the deviceinfoendpoint server.  After setting any
   * optional parameters, call the {@link InsertDeviceInfo#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.google.api.services.deviceinfoendpoint.model.DeviceInfo}
   * @return the request
   */
  public InsertDeviceInfo insertDeviceInfo(com.google.api.services.deviceinfoendpoint.model.DeviceInfo content) throws java.io.IOException {
    InsertDeviceInfo result = new InsertDeviceInfo(content);
    initialize(result);
    return result;
  }

  public class InsertDeviceInfo extends DeviceinfoendpointRequest<com.google.api.services.deviceinfoendpoint.model.DeviceInfo> {

    private static final String REST_PATH = "deviceinfo";

    /**
     * Create a request for the method "insertDeviceInfo".
     *
     * This request holds the parameters needed by the the deviceinfoendpoint server.  After setting
     * any optional parameters, call the {@link InsertDeviceInfo#execute()} method to invoke the
     * remote operation. <p> {@link InsertDeviceInfo#initialize(com.google.api.client.googleapis.servi
     * ces.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param content the {@link com.google.api.services.deviceinfoendpoint.model.DeviceInfo}
     * @since 1.13
     */
    protected InsertDeviceInfo(com.google.api.services.deviceinfoendpoint.model.DeviceInfo content) {
      super(Deviceinfoendpoint.this, "POST", REST_PATH, content, com.google.api.services.deviceinfoendpoint.model.DeviceInfo.class);
    }

    @Override
    public InsertDeviceInfo setAlt(java.lang.String alt) {
      return (InsertDeviceInfo) super.setAlt(alt);
    }

    @Override
    public InsertDeviceInfo setFields(java.lang.String fields) {
      return (InsertDeviceInfo) super.setFields(fields);
    }

    @Override
    public InsertDeviceInfo setKey(java.lang.String key) {
      return (InsertDeviceInfo) super.setKey(key);
    }

    @Override
    public InsertDeviceInfo setOauthToken(java.lang.String oauthToken) {
      return (InsertDeviceInfo) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertDeviceInfo setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertDeviceInfo) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertDeviceInfo setQuotaUser(java.lang.String quotaUser) {
      return (InsertDeviceInfo) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertDeviceInfo setUserIp(java.lang.String userIp) {
      return (InsertDeviceInfo) super.setUserIp(userIp);
    }

    @Override
    public InsertDeviceInfo set(String parameterName, Object value) {
      return (InsertDeviceInfo) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listDeviceInfo".
   *
   * This request holds the parameters needed by the the deviceinfoendpoint server.  After setting any
   * optional parameters, call the {@link ListDeviceInfo#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListDeviceInfo listDeviceInfo() throws java.io.IOException {
    ListDeviceInfo result = new ListDeviceInfo();
    initialize(result);
    return result;
  }

  public class ListDeviceInfo extends DeviceinfoendpointRequest<com.google.api.services.deviceinfoendpoint.model.CollectionResponseDeviceInfo> {

    private static final String REST_PATH = "deviceinfo";

    /**
     * Create a request for the method "listDeviceInfo".
     *
     * This request holds the parameters needed by the the deviceinfoendpoint server.  After setting
     * any optional parameters, call the {@link ListDeviceInfo#execute()} method to invoke the remote
     * operation. <p> {@link ListDeviceInfo#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @since 1.13
     */
    protected ListDeviceInfo() {
      super(Deviceinfoendpoint.this, "GET", REST_PATH, null, com.google.api.services.deviceinfoendpoint.model.CollectionResponseDeviceInfo.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListDeviceInfo setAlt(java.lang.String alt) {
      return (ListDeviceInfo) super.setAlt(alt);
    }

    @Override
    public ListDeviceInfo setFields(java.lang.String fields) {
      return (ListDeviceInfo) super.setFields(fields);
    }

    @Override
    public ListDeviceInfo setKey(java.lang.String key) {
      return (ListDeviceInfo) super.setKey(key);
    }

    @Override
    public ListDeviceInfo setOauthToken(java.lang.String oauthToken) {
      return (ListDeviceInfo) super.setOauthToken(oauthToken);
    }

    @Override
    public ListDeviceInfo setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListDeviceInfo) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListDeviceInfo setQuotaUser(java.lang.String quotaUser) {
      return (ListDeviceInfo) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListDeviceInfo setUserIp(java.lang.String userIp) {
      return (ListDeviceInfo) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListDeviceInfo setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Integer limit;

    /**

     */
    public java.lang.Integer getLimit() {
      return limit;
    }

    public ListDeviceInfo setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListDeviceInfo set(String parameterName, Object value) {
      return (ListDeviceInfo) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeDeviceInfo".
   *
   * This request holds the parameters needed by the the deviceinfoendpoint server.  After setting any
   * optional parameters, call the {@link RemoveDeviceInfo#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveDeviceInfo removeDeviceInfo(java.lang.String id) throws java.io.IOException {
    RemoveDeviceInfo result = new RemoveDeviceInfo(id);
    initialize(result);
    return result;
  }

  public class RemoveDeviceInfo extends DeviceinfoendpointRequest<com.google.api.services.deviceinfoendpoint.model.DeviceInfo> {

    private static final String REST_PATH = "deviceinfo/{id}";

    /**
     * Create a request for the method "removeDeviceInfo".
     *
     * This request holds the parameters needed by the the deviceinfoendpoint server.  After setting
     * any optional parameters, call the {@link RemoveDeviceInfo#execute()} method to invoke the
     * remote operation. <p> {@link RemoveDeviceInfo#initialize(com.google.api.client.googleapis.servi
     * ces.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveDeviceInfo(java.lang.String id) {
      super(Deviceinfoendpoint.this, "DELETE", REST_PATH, null, com.google.api.services.deviceinfoendpoint.model.DeviceInfo.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveDeviceInfo setAlt(java.lang.String alt) {
      return (RemoveDeviceInfo) super.setAlt(alt);
    }

    @Override
    public RemoveDeviceInfo setFields(java.lang.String fields) {
      return (RemoveDeviceInfo) super.setFields(fields);
    }

    @Override
    public RemoveDeviceInfo setKey(java.lang.String key) {
      return (RemoveDeviceInfo) super.setKey(key);
    }

    @Override
    public RemoveDeviceInfo setOauthToken(java.lang.String oauthToken) {
      return (RemoveDeviceInfo) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveDeviceInfo setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveDeviceInfo) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveDeviceInfo setQuotaUser(java.lang.String quotaUser) {
      return (RemoveDeviceInfo) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveDeviceInfo setUserIp(java.lang.String userIp) {
      return (RemoveDeviceInfo) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public RemoveDeviceInfo setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveDeviceInfo set(String parameterName, Object value) {
      return (RemoveDeviceInfo) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateDeviceInfo".
   *
   * This request holds the parameters needed by the the deviceinfoendpoint server.  After setting any
   * optional parameters, call the {@link UpdateDeviceInfo#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.google.api.services.deviceinfoendpoint.model.DeviceInfo}
   * @return the request
   */
  public UpdateDeviceInfo updateDeviceInfo(com.google.api.services.deviceinfoendpoint.model.DeviceInfo content) throws java.io.IOException {
    UpdateDeviceInfo result = new UpdateDeviceInfo(content);
    initialize(result);
    return result;
  }

  public class UpdateDeviceInfo extends DeviceinfoendpointRequest<com.google.api.services.deviceinfoendpoint.model.DeviceInfo> {

    private static final String REST_PATH = "deviceinfo";

    /**
     * Create a request for the method "updateDeviceInfo".
     *
     * This request holds the parameters needed by the the deviceinfoendpoint server.  After setting
     * any optional parameters, call the {@link UpdateDeviceInfo#execute()} method to invoke the
     * remote operation. <p> {@link UpdateDeviceInfo#initialize(com.google.api.client.googleapis.servi
     * ces.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param content the {@link com.google.api.services.deviceinfoendpoint.model.DeviceInfo}
     * @since 1.13
     */
    protected UpdateDeviceInfo(com.google.api.services.deviceinfoendpoint.model.DeviceInfo content) {
      super(Deviceinfoendpoint.this, "PUT", REST_PATH, content, com.google.api.services.deviceinfoendpoint.model.DeviceInfo.class);
    }

    @Override
    public UpdateDeviceInfo setAlt(java.lang.String alt) {
      return (UpdateDeviceInfo) super.setAlt(alt);
    }

    @Override
    public UpdateDeviceInfo setFields(java.lang.String fields) {
      return (UpdateDeviceInfo) super.setFields(fields);
    }

    @Override
    public UpdateDeviceInfo setKey(java.lang.String key) {
      return (UpdateDeviceInfo) super.setKey(key);
    }

    @Override
    public UpdateDeviceInfo setOauthToken(java.lang.String oauthToken) {
      return (UpdateDeviceInfo) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateDeviceInfo setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateDeviceInfo) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateDeviceInfo setQuotaUser(java.lang.String quotaUser) {
      return (UpdateDeviceInfo) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateDeviceInfo setUserIp(java.lang.String userIp) {
      return (UpdateDeviceInfo) super.setUserIp(userIp);
    }

    @Override
    public UpdateDeviceInfo set(String parameterName, Object value) {
      return (UpdateDeviceInfo) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Deviceinfoendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Deviceinfoendpoint}. */
    @Override
    public Deviceinfoendpoint build() {
      return new Deviceinfoendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link DeviceinfoendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setDeviceinfoendpointRequestInitializer(
        DeviceinfoendpointRequestInitializer deviceinfoendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(deviceinfoendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
