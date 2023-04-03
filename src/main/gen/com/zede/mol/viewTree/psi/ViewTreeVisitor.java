// This is a generated file. Not intended for manual editing.
package com.zede.mol.viewTree.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class ViewTreeVisitor extends PsiElementVisitor {

  public void visitItem(@NotNull ViewTreeItem o) {
    visitPsiElement(o);
  }

  public void visitItemContent(@NotNull ViewTreeItemContent o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
