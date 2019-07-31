/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package backend.feedback.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Comment service. Represents a row in the &quot;opencps_comment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link backend.feedback.model.impl.CommentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link backend.feedback.model.impl.CommentImpl}.
 * </p>
 *
 * @author sondt
 * @see Comment
 * @see backend.feedback.model.impl.CommentImpl
 * @see backend.feedback.model.impl.CommentModelImpl
 * @generated
 */
@ProviderType
public interface CommentModel extends BaseModel<Comment>, GroupedModel,
	ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a comment model instance should use the {@link Comment} interface instead.
	 */

	/**
	 * Returns the primary key of this comment.
	 *
	 * @return the primary key of this comment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this comment.
	 *
	 * @param primaryKey the primary key of this comment
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this comment.
	 *
	 * @return the uuid of this comment
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this comment.
	 *
	 * @param uuid the uuid of this comment
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the comment ID of this comment.
	 *
	 * @return the comment ID of this comment
	 */
	public long getCommentId();

	/**
	 * Sets the comment ID of this comment.
	 *
	 * @param commentId the comment ID of this comment
	 */
	public void setCommentId(long commentId);

	/**
	 * Returns the company ID of this comment.
	 *
	 * @return the company ID of this comment
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this comment.
	 *
	 * @param companyId the company ID of this comment
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this comment.
	 *
	 * @return the group ID of this comment
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this comment.
	 *
	 * @param groupId the group ID of this comment
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this comment.
	 *
	 * @return the user ID of this comment
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this comment.
	 *
	 * @param userId the user ID of this comment
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this comment.
	 *
	 * @return the user uuid of this comment
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this comment.
	 *
	 * @param userUuid the user uuid of this comment
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this comment.
	 *
	 * @return the user name of this comment
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this comment.
	 *
	 * @param userName the user name of this comment
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this comment.
	 *
	 * @return the create date of this comment
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this comment.
	 *
	 * @param createDate the create date of this comment
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this comment.
	 *
	 * @return the modified date of this comment
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this comment.
	 *
	 * @param modifiedDate the modified date of this comment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the class name of this comment.
	 *
	 * @return the class name of this comment
	 */
	@AutoEscape
	public String getClassName();

	/**
	 * Sets the class name of this comment.
	 *
	 * @param className the class name of this comment
	 */
	public void setClassName(String className);

	/**
	 * Returns the class pk of this comment.
	 *
	 * @return the class pk of this comment
	 */
	@AutoEscape
	public String getClassPK();

	/**
	 * Sets the class pk of this comment.
	 *
	 * @param classPK the class pk of this comment
	 */
	public void setClassPK(String classPK);

	/**
	 * Returns the fullname of this comment.
	 *
	 * @return the fullname of this comment
	 */
	@AutoEscape
	public String getFullname();

	/**
	 * Sets the fullname of this comment.
	 *
	 * @param fullname the fullname of this comment
	 */
	public void setFullname(String fullname);

	/**
	 * Returns the email of this comment.
	 *
	 * @return the email of this comment
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this comment.
	 *
	 * @param email the email of this comment
	 */
	public void setEmail(String email);

	/**
	 * Returns the parent of this comment.
	 *
	 * @return the parent of this comment
	 */
	public long getParent();

	/**
	 * Sets the parent of this comment.
	 *
	 * @param parent the parent of this comment
	 */
	public void setParent(long parent);

	/**
	 * Returns the content of this comment.
	 *
	 * @return the content of this comment
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this comment.
	 *
	 * @param content the content of this comment
	 */
	public void setContent(String content);

	/**
	 * Returns the file entry ID of this comment.
	 *
	 * @return the file entry ID of this comment
	 */
	public long getFileEntryId();

	/**
	 * Sets the file entry ID of this comment.
	 *
	 * @param fileEntryId the file entry ID of this comment
	 */
	public void setFileEntryId(long fileEntryId);

	/**
	 * Returns the pings of this comment.
	 *
	 * @return the pings of this comment
	 */
	@AutoEscape
	public String getPings();

	/**
	 * Sets the pings of this comment.
	 *
	 * @param pings the pings of this comment
	 */
	public void setPings(String pings);

	/**
	 * Returns the upvote count of this comment.
	 *
	 * @return the upvote count of this comment
	 */
	public int getUpvoteCount();

	/**
	 * Sets the upvote count of this comment.
	 *
	 * @param upvoteCount the upvote count of this comment
	 */
	public void setUpvoteCount(int upvoteCount);

	/**
	 * Returns the user has upvoted of this comment.
	 *
	 * @return the user has upvoted of this comment
	 */
	@AutoEscape
	public String getUserHasUpvoted();

	/**
	 * Sets the user has upvoted of this comment.
	 *
	 * @param userHasUpvoted the user has upvoted of this comment
	 */
	public void setUserHasUpvoted(String userHasUpvoted);

	/**
	 * Returns the upvoted users of this comment.
	 *
	 * @return the upvoted users of this comment
	 */
	@AutoEscape
	public String getUpvotedUsers();

	/**
	 * Sets the upvoted users of this comment.
	 *
	 * @param upvotedUsers the upvoted users of this comment
	 */
	public void setUpvotedUsers(String upvotedUsers);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Comment comment);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Comment> toCacheModel();

	@Override
	public Comment toEscapedModel();

	@Override
	public Comment toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}