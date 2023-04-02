// This is a generated file. Not intended for manual editing.
package com.zede.mol.tree.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class TreeVisitor extends PsiElementVisitor {

  public void visitItem(@NotNull TreeItem o) {
    visitPsiElement(o);
  }

  public void visitItemContent(@NotNull TreeItemContent o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
