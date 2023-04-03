// This is a generated file. Not intended for manual editing.
package com.zede.mol.viewTree.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.zede.mol.viewTree.psi.ViewTreeTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.zede.mol.viewTree.psi.*;

public class ViewTreeItemContentImpl extends ASTWrapperPsiElement implements ViewTreeItemContent {

  public ViewTreeItemContentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ViewTreeVisitor visitor) {
    visitor.visitItemContent(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ViewTreeVisitor) accept((ViewTreeVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ViewTreeItem> getItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ViewTreeItem.class);
  }

}