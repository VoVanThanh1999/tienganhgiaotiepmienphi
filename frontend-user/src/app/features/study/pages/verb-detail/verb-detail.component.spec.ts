import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerbDetailComponent } from './verb-detail.component';

describe('VerbDetailComponent', () => {
  let component: VerbDetailComponent;
  let fixture: ComponentFixture<VerbDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VerbDetailComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VerbDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
