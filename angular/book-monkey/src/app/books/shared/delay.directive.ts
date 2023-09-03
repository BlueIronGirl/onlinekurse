import {Directive, Input, TemplateRef, ViewContainerRef} from '@angular/core';

@Directive({
  selector: '[bmDelay]'
})
export class DelayDirective {
  @Input() bmDelay: number | undefined;

  constructor(private templateRef: TemplateRef<any>, private viewContainerRef: ViewContainerRef) {
  }

  ngOnInit(): void {
    setTimeout(() => {
      this.viewContainerRef.createEmbeddedView(this.templateRef);
    }, this.bmDelay);
  }
}
