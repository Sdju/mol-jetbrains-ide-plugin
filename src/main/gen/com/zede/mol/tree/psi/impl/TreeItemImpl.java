// This is a generated file. Not intended for manual editing.
package com.zede.mol.tree.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.zede.mol.tree.psi.TreeTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.zede.mol.tree.psi.*;

public class TreeItemImpl extends ASTWrapperPsiElement implements TreeItem {

  public TreeItemImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TreeVisitor visitor) {
    visitor.visitItem(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TreeVisitor) accept((TreeVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TreeItemContent getItemContent() {
    return findChildByClass(TreeItemContent.class);
  }

}
