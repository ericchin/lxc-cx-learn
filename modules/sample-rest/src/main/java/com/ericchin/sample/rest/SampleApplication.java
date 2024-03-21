package com.ericchin.sample.rest;

import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Collections;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Eric Chin
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/sample",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Sample.Rest"
	},
	service = Application.class
)
public class SampleApplication extends Application {

	@Override
	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@POST
	@Path("/action")
	@Produces(MediaType.APPLICATION_JSON)
	public Response postAction(@Context HttpServletRequest httpServletRequest) {
		_log.info("Triggered Object Action");

		return Response.ok(
			JSONUtil.put("message", "success").toString()
		).build();
	}

	private static final Log _log = LogFactoryUtil.getLog(SampleApplication.class);

}
